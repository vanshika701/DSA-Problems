class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
//         HashMap<Character,Integer> map=new HashMap<>();
//         int p=0;
//         for(int i=0;i<ransomNote.length();i++){
//             char ch = ransomNote.charAt(i);

//     if(map.containsKey(ch)) {
//         map.put(ch, map.get(ch) + 1);
//     }
//     else {
//         map.put(ch, 1);
//         }
//         }
//     for(int i=0;i<magazine.length();i++){
//             char ch = magazine.charAt(i);

//     if(map.containsKey(ch)) {
//         map.put(ch, map.get(ch) - 1);
//     }
//         }
//     for(int val : map.values()) {
//     if(val > 0) {
//         return false;
//     }
// }
//         return true;

    int arr[]=new int[26];
    for(int i=0;i<magazine.length();i++){
        arr[magazine.charAt(i)-'a']+=1;
    }
    for(int i=0;i<ransomNote.length();i++){
        arr[ransomNote.charAt(i)-'a']-=1;
        if(arr[ransomNote.charAt(i)-'a']<0)
        return false;
    }
    return true;
    }

}