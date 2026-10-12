class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int canReach = n - 1;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] + i >= canReach){
                canReach = i;
            }
        }
        return canReach == 0;
    }
}
