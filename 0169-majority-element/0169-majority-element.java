class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=nums.length;
        int l=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>n/2)
            return num;
        }
        return -1;
    }
}