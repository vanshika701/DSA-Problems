class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
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