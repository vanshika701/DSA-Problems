class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> map=new HashMap<> ();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch,1);
        }
        for(int i=0; i<t.length(); i++){
            char ch=t.charAt(i);
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)-1);
        }
        for(char key:map.keySet()){
            if(map.get(key)!=0)
            {
                return false;
            }
        }
        return true;
    }
}