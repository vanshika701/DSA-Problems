class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> l1=new ArrayList<>();
    HashMap<String, List<String>> map=new HashMap<>();
    for(int i=0;i<strs.length;i++){
        int[] freq=new int[26];
        String s=strs[i];
        for(int j=0;j<s.length();j++){
            freq[s.charAt(j)-'a']++;
        }
         StringBuilder key = new StringBuilder();
         for(int k=0;k<26;k++){
            key.append('#').append(freq[k]);
         }
         String k = key.toString();
         if(!map.containsKey(k)){
            map.put(k, new ArrayList<>());
         }
            map.get(k).add(s);
    }
    for(String key:map.keySet()){
        l1.add(map.get(key));
    }
    return l1;
    }
}
/*1. Sorting each string
Idea: Two strings are anagrams if sorting their characters produces the same string.

For example, "eat", "tea", and "ate" all become "aet" after sorting. We use this sorted string as the key in a HashMap<String, List<String>>, where each key maps to a list of original strings.

Algorithm:
1. Create a HashMap to store the anagram groups.
2. Iterate through every string in the input array.
3. Convert the current string into a character array and sort it using Arrays.sort().
4. Convert the sorted array back into a string to use as the key.
5. If the key doesn't exist, create a new list for it.
6. Add the original string to the list associated with that key.
7. Return all the lists stored in the map.
Complexity analysis:
- Time: \(O(nk\log k)\), where \(n\) is the number of strings and \(k\) is the maximum string length. Sorting each string takes \(O(k\log k)\).
- Space: \(O(nk)\) for storing the groups and keys, excluding the output if counted separately.

Approach 2 · Character Frequency
2. Frequency counting
Idea: Instead of sorting each string, count how many times each letter appears. Anagrams have identical character frequencies, so they produce the same key.

For example, "eat", "tea", and "ate" each contain one a, one e, and one t. Their frequency arrays are identical.

Algorithm:
1. Create a HashMap to store the anagram groups.
2. Iterate through every string in the input array.
3. Create an integer array of size 26 to count the frequencies of lowercase English letters.
4. For each character c, increment freq[c - 'a'].
5. Convert the frequency array into a unique string key using StringBuilder, separating the counts with #.
6. If the key doesn't exist, create a new list for it.
7. Add the original string to the corresponding list.
8. Return all the lists stored in the map.
Complexity analysis:
- Time: \(O(nk)\), because counting the characters and constructing each key takes linear time per string, assuming a fixed 26-letter alphabet.
- Space: \(O(nk)\) for storing the groups and keys, excluding the output if counted separately.*/