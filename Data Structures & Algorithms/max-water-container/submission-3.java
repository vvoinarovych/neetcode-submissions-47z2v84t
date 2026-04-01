class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;
        while(l < r){
            int lh = heights[l];
            int rh = heights[r];

            int area = Math.min(lh, rh) * (r - l);
            maxArea = Math.max(area, maxArea);
            if(lh <= rh){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
