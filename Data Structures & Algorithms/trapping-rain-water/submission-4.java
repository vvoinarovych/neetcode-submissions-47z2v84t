class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int lmax = 0;
        int rmax = 0;

        int result = 0;
        while(l < r){
            int lh = height[l];
            int rh = height[r];
            
            if(lh <= rh){
                lmax = Math.max(lh, lmax);
                result += lmax - lh;
                l++;
            }else{
                rmax = Math.max(rh, rmax);
                result += rmax - rh;
                r--;
            }
        }
        return result;
    }
}
