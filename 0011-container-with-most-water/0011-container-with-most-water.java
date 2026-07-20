class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int water=0;
        int max=0;
        while(l<r){
            int min=Math.min(height[r],height[l]);
            water=min*(r-l);
            if(height[l]<height[r])
            l++;
            else
            r--;
            max=Math.max(max,water);
        }
        return max;
    }
}