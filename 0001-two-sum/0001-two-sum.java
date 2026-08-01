class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
      HashMap<Integer, Integer> map=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        map.put(nums[i],i);
      }
      for(int i=0;i<nums.length;i++){
        if(map.containsKey(target-nums[i]))
        {
            if(map.get(target - nums[i]) != i){
            ans[0]=Math.min(i,map.get(target-nums[i]));
            ans[1]=Math.max(i,map.get(target-nums[i]));
        }
        }
      }
      return ans;
    }
}
