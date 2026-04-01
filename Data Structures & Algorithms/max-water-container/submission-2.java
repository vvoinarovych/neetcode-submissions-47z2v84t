class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxVolume = 0;
        while(left < right){
            int lh = heights[left];
            int rh = heights[right];
            int volume = Math.min(lh, rh) * (right - left);
            maxVolume = Math.max(maxVolume, volume);
            if(lh <= rh){
                left++;
            }else{
                right--;
            }
        }
        return maxVolume;
    }
}
