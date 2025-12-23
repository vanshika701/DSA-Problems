class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()==t.length()){
            HashMap <Character,Character> map=new HashMap<>();
            HashMap <Character,Character> map1=new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i))){
                    char oldval=map.get(s.charAt(i));
                    if (oldval!=t.charAt(i)){
                        return false;
                    }
                }else{
                map.put(s.charAt(i),t.charAt(i));
            }
             if(map1.containsKey(t.charAt(i))){
                    char oldval=map1.get(t.charAt(i));
                    if (oldval!=s.charAt(i)){
                        return false;
                    }
                }else{
                map1.put(t.charAt(i),s.charAt(i));
            }
            }
        return true; }
        else{
            return false;
        } 
    }
}