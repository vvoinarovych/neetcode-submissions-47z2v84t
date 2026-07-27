class Solution {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int jumps = 0;
        while(r < nums.length - 1){
            int farthest = 0;
            for(int j = l; j <= r; j++){
                farthest = Math.max(farthest, nums[j] + j);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}
