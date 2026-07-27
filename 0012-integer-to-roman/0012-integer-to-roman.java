class Solution {
    public String intToRoman(int num) {
        //already optimal soln but we can do it in a shorter method using two array approach
        //rn we have O(1) of both time and space compexity
        //hum isme sbse phle biggest number subtract krte abd uska corres symbol string mei add krdete
//         StringBuilder sb=new StringBuilder("");
//         while(num>0){
//         if(num>=1000){
//             num-=1000;
//             sb.append("M");
//         }
//         else
//             if(num>=900){
//                 num-=900;
//                 sb.append("CM");
//             }
//         else
//             if(num>=500){
//                 num-=500;
//                 sb.append("D");
//             }
//         else
//             if(num>=400){
//                 num-=400;
//                 sb.append("CD");
//             }
//         else
//             if(num>=100){
//                 num-=100;
//                 sb.append("C");
//             }
//         else
//             if(num>=90){
//                 num-=90;
//                 sb.append("XC");
//             }
//         else
//             if(num>=50){
//                 num-=50;
//                 sb.append("L");
//             }
//         else
//             if(num>=40){
//                 num-=40;
//                 sb.append("XL");
//             }
//         else
//             if(num>=10){
//                 num-=10;
//                 sb.append("X");
//             }
//         else
//             if(num>=9){
//                 num-=9;
//                 sb.append("IX");
//             }
//         else
//             if(num>=5){
//                 num-=5;
//                 sb.append("V");
//             }
//         else
//             if(num>=4){
//                 num-=4;
//                 sb.append("IV");
//             }
//         else
//             if(num>=1){
//                 num-=1;
//                 sb.append("I");
//             }
//         }
//         return sb.toString();
//     }
// }


int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
 StringBuilder ans = new StringBuilder("");
for (int i = 0; i < values.length; i++) {
    while (num >= values[i]) {
        ans.append(symbols[i]);
        num -= values[i];
    }
}
return ans.toString();
    }
}
