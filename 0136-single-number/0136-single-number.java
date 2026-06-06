class Solution {
    public int singleNumber(int[] nums) {
        // int n=0;
        // HashMap<Integer, Integer> map=new HashMap<>();
        // for(int num:nums){
        //     map.put(num,map.getOrDefault(num,0)+1);
        // }
        // for(int num:nums){
        //     if(map.get(num)==1)
        //     n=num;
        // }
        // return n;
        int xor=nums[0];
        for(int i=1;i<nums.length;i++){
            xor=xor^nums[i];
        }
        return xor;
    }
}