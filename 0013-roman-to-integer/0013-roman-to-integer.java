class Solution {
    // public int romanToInt(String s) {
//         int l=s.length();
//         HashMap<Character, Integer> map=new HashMap<>();
//         map.put('I',1);
//         map.put('V',5);
//         map.put('X',10);
//         map.put('L',50);
//         map.put('C',100);
//         map.put('D',500);
//         map.put('M',1000);

//         int sum=0;
//         for(int i=0;i<l-1;i++){
//             if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
//                 sum-=map.get(s.charAt(i));//ye subtracr krne ka ye reason hai ki charat(i) ki value charat(i+1) se kamm tb hogi jab 9 ya 4 jaise number s honge toh jaise nine hai IX toh humne phle I ko minus krdia and fir 10 ko plus bn gya 9
//             }
//             else{
//                 sum+=map.get(s.charAt(i));
//             }
//         }
//         sum+=map.get(s.charAt(l-1));
//         return sum;
//     }
// }
// // can use switch statement instead of hash, it will reduce the space overhead



//soln2 using switch case to reduce space overhaed
private int value(char letter){
switch (letter){
    case 'I':
    return 1;

     case 'V':
    return 5;

     case 'X':
    return 10;

     case 'L':
    return 50;

     case 'C':
    return 100;

     case 'D':
    return 500;

     case 'M':
    return 1000;

    default:
    return 0;

}
}

 public int romanToInt(String s) {
    int l=s.length();
    int sum=0;
    for(int i=0;i<l-1;i++){
        if(value(s.charAt(i))<value(s.charAt(i+1)))
        sum-=value(s.charAt(i));
        else
        sum+=value(s.charAt(i));
    }
    sum += value(s.charAt(l - 1));
    return sum;
 }
}