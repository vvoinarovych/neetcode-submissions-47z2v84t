class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int lmax = height[left];
        int rmax = height[right];
        int volume = 0;
        while(left < right){
            int lh = height[left];
            int rh = height[right];

            if(lh <= rh){
                lmax = Math.max(lmax, lh);
                volume += lmax - lh;
                left++;
            }else{
                rmax = Math.max(rmax, rh);
                volume += rmax - rh;
                right--;
            }

        }
        return volume;
    }
}
