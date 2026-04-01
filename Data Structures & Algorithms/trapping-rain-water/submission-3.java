class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lmax = height[l];
        int rmax = height[r];
        int total = 0;
        while(l < r){
            int lh = height[l];
            int rh = height[r];
            
            if(lh <= rh){
                lmax = Math.max(lmax, lh);
                total += lmax - lh;
                l++;
            }else{
                rmax = Math.max(rmax, rh);
                total += rmax - rh;
                r--;
            }
        }
        return total;
    }
}
