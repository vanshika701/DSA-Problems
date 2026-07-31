class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int k=0;
        int len=0;
        int max=0;
        for (int num : set){
            if(!set.contains(num-1)){
                k=num;
                len=1;
            while(set.contains(k+1))
            {
                len++;
                k++;
            }
            }
            max=Math.max(len,max);
        }
        return max;
    }
}