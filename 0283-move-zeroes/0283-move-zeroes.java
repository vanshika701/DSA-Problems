class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0; // position to place the next non-zero
        
        // Step 1: Move all non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[write] = nums[i];
                write++;
            }
        }
        
        // Step 2: Fill the rest with zeros
        for (int i = write; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
