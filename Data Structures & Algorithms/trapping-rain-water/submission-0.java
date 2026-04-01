class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int lmax = height[0];
        int rmax = height[height.length - 1];

        int result = 0;
        //lmax    0 2 2 2
        //rmax    0 1 2 2
        //lh:     0 2 2 0
        //rh:     1 1 2 2
        //result: 0 0 0 2
        while(l < r){
            int lh = height[l];
            int rh = height[r];            

            if(lh <= rh){
                lmax = Math.max(lmax, lh);
                int toAdd = lmax - lh;
                result += toAdd;
                
                l++;
            }else{
                rmax = Math.max(rmax, rh);
                result += rmax - rh;
                
                r--;
            }
        }
        return result;
    }
}
