class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {  // ✅ start from i+1
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;               // ✅ directly return
                }
            }
        }
        return result; // should never reach here (per problem statement)
    }
}
