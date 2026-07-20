class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //We first sort the array so that we can use the two-pointer technique efficiently and easily skip duplicate triplets. For each element `nums[i]`, we fix it as the first number and use two pointers (`left` and `right`) to find the other two numbers whose sum with `nums[i]` is `0`. If the sum is too small, we move `left` forward; if it's too large, we move `right` backward. When a valid triplet is found, we add it to the answer and skip duplicate values for `i`, `left`, and `right` to ensure each triplet is included only once. The overall time complexity is **O(n²)** and the extra space is **O(1)** (excluding the output list).

        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
             if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
            if(nums[l]+nums[r]==-nums[i]){//main logic
            List<Integer> temp=new ArrayList<>();
                temp.add(nums[l]);
                temp.add(nums[r]);
                temp.add(nums[i]);
                list.add(temp);
                l++;
                r--;

                while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    // Skip duplicate right elements
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
            }else
            if(nums[l]+nums[r]>-nums[i])
            r--;
            else
            if(nums[l]+nums[r]<-nums[i])
            l++;
            }
        }
        return list;
    }
}