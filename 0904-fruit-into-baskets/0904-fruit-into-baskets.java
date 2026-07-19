class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int n=fruits.length;
        int ele=0;
        int max=0;
        while(r<n){
            if(map.getOrDefault(fruits[r],0)>0){
                map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            }
            else
            {
                map.put(fruits[r],1);
                ele++;
            }
            while(ele>2){
                map.put(fruits[l],map.getOrDefault(fruits[l],0)-1);
                if(map.getOrDefault(fruits[l],0)==0)
               { 
                ele--;
                }
                l++;
            }
            max=Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}