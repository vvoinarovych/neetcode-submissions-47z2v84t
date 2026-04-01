class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int lmax = height[l];
        int rmax = height[r];

        int volume = 0;
        while(l < r){
            int lh = height[l];
            int rh = height[r];

            if(lh <= rh){
                lmax = Math.max(lh, lmax);
                volume += lmax - lh;
                l++;
            }else{
                rmax = Math.max(rh, rmax);
                volume += rmax - rh;
                r--;
            }
        }
        return volume;
    }
}
