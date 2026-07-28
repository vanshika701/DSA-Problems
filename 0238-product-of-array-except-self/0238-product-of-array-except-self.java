class Solution {
    public int[] productExceptSelf(int[] nums) {
        //this is not the optimal solution
        //SC-O(n), TC-O(n)
//         List<Integer> list=new ArrayList<>();
//         int l=nums.length;
//         int prod=1;
//         int[] answer=new int[l];
//         for(int i=0;i<l;i++){
//             if(nums[i]==0)
//             list.add(i);
//             else
//             prod*=nums[i];
//         }
//         for(int i=0;i<l;i++){
//             if(list.size()==0)
//             answer[i]=prod/nums[i];
//             else
//             if(list.size()==1){
//              if (i == list.get(0))
//                 answer[i] = prod;
//             else
//                 answer[i] = 0;
//             }
//             else
//             if(list.size()>1){
//                 prod=0;
//                 answer[i]=prod;
//             }
//         }
//         return answer;
//     }
// }


//ye hoga optimal soln isme hum koi extra data structure use nhi krenge bass do prefix and suffix pointers use krenge

int prefix=1;
int suffix=1;
int l=nums.length;
int[] answer=new int[l];
answer[0]=prefix;
for(int i=1;i<l;i++){
    answer[i]=prefix*nums[i-1];
    prefix=answer[i];
}
answer[l-1]*=suffix;
suffix*=nums[l-1];
for(int i=l-2;i>=0;i--){
    answer[i]*=suffix;
    suffix*=nums[i];
}
return answer;
    }
}