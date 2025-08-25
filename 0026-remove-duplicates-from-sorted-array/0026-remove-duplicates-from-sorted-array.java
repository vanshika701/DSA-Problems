class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> dubli=new HashMap<> ();
        for(int i:nums){
            dubli.put(i, dubli.getOrDefault(i,0)+1);
        }
        List<Integer> keys = new ArrayList<>(dubli.keySet());
        Collections.sort(keys);

        int i=0;
        int k=0;
        for(int key:keys){
            nums[i]=key;
            i++;
            k++;
        }
        return k;
    }
}