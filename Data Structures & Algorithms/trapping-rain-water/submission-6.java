class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lmax = 0;
        int rmax = 0;
        int result = 0;

        while(l < r){
            int lCur = height[l];
            int rCur = height[r];

            if(lCur <= rCur){
                lmax = Math.max(lmax, lCur);
                result += lmax - lCur;
                l++;
            }else{
                rmax  =Math.max(rmax, rCur);
                result += rmax - rCur;
                r--;
            }
        }
        return result;
    }
}
