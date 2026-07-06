class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max = 0;
        while(l < r){
            int lh = heights[l];
            int rh = heights[r];
            max = Math.max(max, Math.min(lh,rh) * (r - l));
            if(lh > rh){
                r--;
            }else{
                l++;
            }
        }
        return max;
    }
}
