class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map1=new HashMap<>();
        HashMap<Character, String> map2=new HashMap<>();
        String parts[]=s.split(" ");
        if(pattern.length()!=parts.length)
        return false;
        for(int i=0;i<pattern.length();i++){
            if(map2.containsKey(pattern.charAt(i))&&!map2.get(pattern.charAt(i)).equals(parts[i]))
            return false;
            else
            map2.put(pattern.charAt(i),parts[i]);
            if(map1.containsKey(parts[i])&&!map1.get(parts[i]).equals(pattern.charAt(i)))
            return false;
            else
            map1.put(parts[i],pattern.charAt(i));
        }
        return true;
    }
}