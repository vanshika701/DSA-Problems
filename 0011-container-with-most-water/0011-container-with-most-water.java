class Solution {
    public int maxArea(int[] height) {
        //Approach: Use two pointers, one at each end of the array. In each step, calculate the area formed by the two lines and update the maximum area. Then move the pointer with the shorter height inward because the area is limited by the shorter line, and moving the taller line cannot increase the area while the width decreases. Continue until the pointers meet.
        //Time Complexity: O(n) – each pointer moves at most n times.
        //Space Complexity: O(1) – only constant extra space is used.     
        int l=0;
        int r=height.length-1;
        int max=0;
        while(l<r){
            int min=Math.min(height[r],height[l]);
            max=Math.max(max,min*(r-l));
            if(height[l]<height[r])
            l++;
            else
            r--;
        }
        return max;
    }
}