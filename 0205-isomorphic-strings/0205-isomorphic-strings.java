class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        // HashMap<Character, Character> map = new HashMap<>();
        // HashMap<Character, Character> map1 = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     char a = s.charAt(i);
        //     char b = t.charAt(i);
        //     if (map.containsKey(a)) {
        //         if (map.get(a) != b) return false;
        //     } else {
        //         map.put(a, b);
        //     }
        //     if (map1.containsKey(b)) {
        //         if (map1.get(b) != a) return false;
        //     } else {
        //         map1.put(b, a);
        //     }
        // }
        // return true;
        char[] arr=new char[128];
        char[] arr1=new char[128];
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            if ((arr[a] != 0 && arr[a] != b) ||
                (arr1[b] != 0 && arr1[b] != a))
            return false;
            arr[a]=b;
            arr1[b]=a;
        }
        return true;
    }
}