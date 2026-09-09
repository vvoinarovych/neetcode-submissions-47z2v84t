class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int r = heights.length - 1;

        while(l < r){
            int lh = heights[l];
            int rh = heights[r];
            max = Math.max(max, (r - l) * Math.min(lh,rh));
            if(lh <= rh){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
