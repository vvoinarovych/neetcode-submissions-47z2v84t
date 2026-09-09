class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int lmax = height[l];
        int rmax = height[r];

        int trap = 0;

        while(l < r){
            int lh = height[l];
            int rh = height[r];
            lmax = Math.max(lmax, lh);
            rmax = Math.max(rmax, rh);
            if(lh <= rh){
                trap += lmax - lh;
                l++;
            }else{
                trap += rmax - rh;
                r--;
            }
        }
        return trap;
    }
}
