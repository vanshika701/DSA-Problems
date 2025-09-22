import streamlit as st
import json
import math
import os
from collections import Counter, defaultdict

# Handle missing dependencies gracefully
try:
    import nltk
    from nltk.corpus import stopwords
    from nltk.stem import PorterStemmer
    NLTK_AVAILABLE = True
except ImportError:
    NLTK_AVAILABLE = False
    st.error("❌ NLTK is not installed. Please install it using: `pip install nltk`")

try:
    import jellyfish
    JELLYFISH_AVAILABLE = True
except ImportError:
    JELLYFISH_AVAILABLE = False
    st.error("❌ Jellyfish is not installed. Please install it using: `pip install jellyfish`")

try:
    from spellchecker import SpellChecker
    SPELLCHECKER_AVAILABLE = True
except ImportError:
    SPELLCHECKER_AVAILABLE = False
    st.error("❌ PySpellChecker is not installed. Please install it using: `pip install pyspellchecker`")

# Download required NLTK data
@st.cache_resource
def download_nltk_data():
    if not NLTK_AVAILABLE:
        return False
    try:
        nltk.download('punkt', quiet=True)
        nltk.download('punkt_tab', quiet=True)
        nltk.download('stopwords', quiet=True)
        return True
    except Exception as e:
        st.error(f"Error downloading NLTK data: {e}")
        return False

# Check dependencies before proceeding
def check_dependencies():
    missing_deps = []
    if not NLTK_AVAILABLE:
        missing_deps.append("nltk")
    if not JELLYFISH_AVAILABLE:
        missing_deps.append("jellyfish")
    if not SPELLCHECKER_AVAILABLE:
        missing_deps.append("pyspellchecker")
    
    if missing_deps:
        st.error("❌ Missing required dependencies!")
        st.markdown("**Please install the following packages:**")
        for dep in missing_deps:
            st.code(f"pip install {dep}")
        st.markdown("**Or install all at once:**")
        st.code(f"pip install {' '.join(missing_deps)}")
        st.stop()
    
    return download_nltk_data()

# --- TEXT PREPROCESSING PIPELINE ---
@st.cache_data
def preprocess_text(text):
    """Preprocess text for indexing/searching"""
    tokens = nltk.word_tokenize(text.lower())
    stop_words = set(stopwords.words("english"))
    filtered = [w for w in tokens if w.isalnum() and w not in stop_words]
    
    ps = PorterStemmer()
    stemmed = [ps.stem(w) for w in filtered]
    return stemmed, [jellyfish.soundex(w) for w in stemmed]

# --- CORPUS READING ---
@st.cache_data
def read_corpus(folder_path):
    """Read and preprocess corpus files"""
    corpus = {}
    if not os.path.exists(folder_path):
        return corpus
        
    for filename in os.listdir(folder_path):
        if filename.endswith(".txt"):
            filepath = os.path.join(folder_path, filename)
            try:
                with open(filepath, "r", encoding="utf-8") as f:
                    text = f.read()
                    processed, soundexed = preprocess_text(text)
                    corpus[filename] = {
                        "original": text,
                        "processed": processed,
                        "soundex": soundexed
                    }
            except Exception as e:
                st.warning(f"Error reading {filename}: {e}")
    return corpus

# --- SPELLING CORRECTION ---
@st.cache_data
def correct_query(query, vocab):
    """Correct spelling mistakes in query"""
    spell = SpellChecker()
    tokens = nltk.word_tokenize(query.lower())
    corrected = []
    
    for word in tokens:
        if word.isalnum():  # Only process alphanumeric words
            if word not in vocab:
                suggestion = spell.correction(word)
                if suggestion is None:
                    # Fallback using levenshtein distance
                    min_dist = float("inf")
                    best = word
                    for v in list(vocab)[:1000]:  # Limit search for performance
                        d = jellyfish.levenshtein_distance(word, v)
                        if d < min_dist and d <= 2:  # Only consider close matches
                            min_dist = d
                            best = v
                    corrected.append(best)
                else:
                    corrected.append(suggestion)
            else:
                corrected.append(word)
        else:
            corrected.append(word)
    return corrected

# --- INVERTED INDEX ---
@st.cache_data
def build_inverted_index(corpus_data):
    """Build inverted index from corpus"""
    inverted_index = defaultdict(lambda: {"df": 0, "postings": []})
    
    for doc_id, doc_info in corpus_data.items():
        processed_terms = doc_info["processed"]
        term_freq = Counter(processed_terms)
        
        for term, freq in term_freq.items():
            inverted_index[term]["postings"].append((doc_id, freq))
            inverted_index[term]["df"] += 1
    
    return dict(inverted_index)

# --- DOCUMENT LENGTHS ---
@st.cache_data
def compute_doc_vector_lengths(inverted_index):
    """Compute document vector lengths for normalization"""
    doc_vectors = {}
    
    for term, info in inverted_index.items():
        for doc_id, tf in info['postings']:
            if doc_id not in doc_vectors:
                doc_vectors[doc_id] = {}
            weight = 1 + math.log10(tf) if tf > 0 else 0
            doc_vectors[doc_id][term] = weight
    
    doc_lengths = {}
    for doc_id, vec in doc_vectors.items():
        length = math.sqrt(sum(w**2 for w in vec.values()))
        doc_lengths[doc_id] = length
    
    return doc_lengths

# --- VECTOR SPACE MODEL SEARCH ---
def search_vsm(query_terms, inverted_index, doc_lengths, top_k=10):
    """Search using Vector Space Model with TF-IDF"""
    N = len(doc_lengths)
    tf_query = Counter(query_terms)
    
    # Calculate query weights
    query_weights = {}
    for term, tf in tf_query.items():
        if term in inverted_index:
            df = inverted_index[term]['df']
            idf = math.log10(N / df) if df > 0 else 0
            weight = (1 + math.log10(tf)) * idf
            query_weights[term] = weight
        else:
            query_weights[term] = 0
    
    # Normalize query vector
    qlen = math.sqrt(sum(w**2 for w in query_weights.values()))
    if qlen > 0:
        for term in query_weights:
            query_weights[term] /= qlen
    
    # Calculate document scores
    scores = {}
    for term, q_weight in query_weights.items():
        if term in inverted_index and q_weight > 0:
            for doc_id, tf in inverted_index[term]['postings']:
                d_weight = 1 + math.log10(tf) if tf > 0 else 0
                d_weight /= doc_lengths[doc_id] if doc_lengths[doc_id] > 0 else 1
                scores[doc_id] = scores.get(doc_id, 0) + q_weight * d_weight
    
    # Rank results
    ranked = sorted(scores.items(), key=lambda x: (-x[1], x[0]))
    return ranked[:top_k]

# --- STREAMLIT APP ---
def main():
    st.set_page_config(
        page_title="📚 Document Search Engine",
        page_icon="🔍",
        layout="wide"
    )
    
    # Header
    st.title("📚 Document Search Engine")
    st.markdown("*Search through your document corpus using TF-IDF Vector Space Model*")
    
    # Check dependencies first
    nltk_ready = check_dependencies()
    if not nltk_ready:
        st.warning("⚠️ NLTK data download failed. Some features may not work correctly.")
    
    # Sidebar for configuration
    st.sidebar.header("⚙️ Configuration")
    corpus_folder = st.sidebar.text_input("Corpus Folder Path", value="Corpus", help="Path to folder containing .txt files")
    top_k = st.sidebar.slider("Number of Results", min_value=1, max_value=20, value=10)
    
    # Initialize session state
    if 'corpus_loaded' not in st.session_state:
        st.session_state.corpus_loaded = False
    if 'inverted_index' not in st.session_state:
        st.session_state.inverted_index = None
    if 'doc_lengths' not in st.session_state:
        st.session_state.doc_lengths = None
    if 'corpus_data' not in st.session_state:
        st.session_state.corpus_data = None
    if 'vocab' not in st.session_state:
        st.session_state.vocab = set()
    
    # Load corpus button
    if st.sidebar.button("🔄 Load/Reload Corpus"):
        with st.spinner("Loading corpus..."):
            corpus_data = read_corpus(corpus_folder)
            if corpus_data:
                st.session_state.corpus_data = corpus_data
                st.session_state.inverted_index = build_inverted_index(corpus_data)
                st.session_state.doc_lengths = compute_doc_vector_lengths(st.session_state.inverted_index)
                st.session_state.vocab = set(st.session_state.inverted_index.keys())
                st.session_state.corpus_loaded = True
                st.sidebar.success(f"✅ Loaded {len(corpus_data)} documents")
            else:
                st.sidebar.error("❌ No documents found in the specified folder")
    
    # Display corpus statistics
    if st.session_state.corpus_loaded:
        col1, col2, col3 = st.columns(3)
        with col1:
            st.metric("📄 Documents", len(st.session_state.corpus_data))
        with col2:
            st.metric("🔤 Unique Terms", len(st.session_state.inverted_index))
        with col3:
            st.metric("📁 Corpus Folder", corpus_folder)
    
    # Search interface
    st.header("🔍 Search Interface")
    
    if not st.session_state.corpus_loaded:
        st.warning("⚠️ Please load a corpus first using the sidebar.")
        st.stop()
    
    # Search input
    query = st.text_input(
        "Enter your search query:",
        placeholder="e.g., environment protection, artificial intelligence, etc.",
        help="Enter keywords to search for relevant documents"
    )
    
    # Search options
    col1, col2 = st.columns([3, 1])
    with col1:
        enable_spell_check = st.checkbox("🔤 Enable spell checking", value=True)
    with col2:
        search_button = st.button("🔍 Search", type="primary")
    
    # Perform search
    if (query and search_button) or (query and st.session_state.get('last_query') != query):
        st.session_state.last_query = query
        
        with st.spinner("Searching..."):
            # Spell correction
            if enable_spell_check:
                original_query = query
                corrected_tokens = correct_query(query, st.session_state.vocab)
                corrected_query = " ".join(corrected_tokens)
                
                if original_query.lower() != corrected_query.lower():
                    st.info(f"🔤 **Spell check:** '{original_query}' → '{corrected_query}'")
                    query_terms, _ = preprocess_text(corrected_query)
                else:
                    query_terms, _ = preprocess_text(query)
            else:
                query_terms, _ = preprocess_text(query)
            
            # Search
            results = search_vsm(
                query_terms, 
                st.session_state.inverted_index, 
                st.session_state.doc_lengths, 
                top_k=top_k
            )
            
            # Display results
            if results:
                st.success(f"🎯 Found {len(results)} relevant documents")
                
                for i, (doc_id, score) in enumerate(results, 1):
                    with st.expander(f"#{i} **{doc_id}** (Score: {score:.4f})"):
                        # Get document content
                        doc_content = st.session_state.corpus_data[doc_id]["original"]
                        
                        # Show preview (first 300 characters)
                        preview = doc_content[:300] + "..." if len(doc_content) > 300 else doc_content
                        st.text_area("Preview:", preview, height=100, disabled=True)
                        
                        # Show full content option
                        if st.button(f"📄 Show full content", key=f"show_{i}"):
                            st.text_area("Full Content:", doc_content, height=300, disabled=True)
                        
                        # Document statistics
                        col1, col2, col3 = st.columns(3)
                        with col1:
                            st.metric("Characters", len(doc_content))
                        with col2:
                            st.metric("Words", len(doc_content.split()))
                        with col3:
                            st.metric("Relevance Score", f"{score:.4f}")
            else:
                st.warning("🔍 No results found. Try different keywords or check spelling.")
    
    # Additional features
    with st.expander("📊 Corpus Analysis"):
        if st.session_state.corpus_loaded:
            # Most frequent terms
            st.subheader("🔥 Most Frequent Terms")
            top_terms = sorted(
                st.session_state.inverted_index.items(),
                key=lambda x: x[1]["df"],
                reverse=True
            )[:20]
            
            terms_df = []
            for term, info in top_terms:
                terms_df.append({
                    "Term": term,
                    "Document Frequency": info["df"],
                    "Total Occurrences": sum(tf for _, tf in info["postings"])
                })
            
            st.dataframe(terms_df, use_container_width=True)
    
    # Footer
    st.markdown("---")
    st.markdown("*Powered by TF-IDF Vector Space Model with NLTK preprocessing*")

if __name__ == "__main__":
    main()