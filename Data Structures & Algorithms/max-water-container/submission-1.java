class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int result = 0;
        while(l < r){
            int lh = heights[l];
            int rh = heights[r];

            int volume = Math.min(lh, rh) * (r - l);
            result = Math.max(volume, result);

            if(lh <= rh){
                l++;
            }else{
                r--;
            }
        }
        return result;
    }
}
