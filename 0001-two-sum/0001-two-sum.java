class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[] result=new int[2];
       HashMap<Integer, Integer> map=new HashMap<>();
       for(int i=0;i<nums.length;i++){
        int second=target-nums[i];
        if(map.containsKey(nums[i])){
            result[0]=map.get(nums[i]);
            result[1]=i;
            return result;
        }
        map.put(second,i);
       }
       return result;
    }
}
