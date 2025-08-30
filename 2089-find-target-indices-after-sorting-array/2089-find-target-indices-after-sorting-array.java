class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int min=i;
            for(int j=i;j<n;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
            }
                int temp=nums[i];
                nums[i]=nums[min];
                nums[min]=temp;
            }
            List<Integer> num=new ArrayList<>();
            for(int k=0;k<n;k++){
                if(nums[k]==target)
                {
                    num.add(k);
                }
            }
            return num;
        }
    }
