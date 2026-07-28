class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int l=nums.length;
        int prod=1;
        int[] answer=new int[l];
        for(int i=0;i<l;i++){
            if(nums[i]==0)
            list.add(i);
            else
            prod*=nums[i];
        }
        for(int i=0;i<l;i++){
            if(list.size()==0)
            answer[i]=prod/nums[i];
            else
            if(list.size()==1){
             if (i == list.get(0))
                answer[i] = prod;
            else
                answer[i] = 0;
            }
            else
            if(list.size()>1){
                prod=0;
                answer[i]=prod;
            }
        }
        return answer;
    }
}