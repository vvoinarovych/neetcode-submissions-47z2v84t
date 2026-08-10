class Solution {
    public boolean canJump(int[] nums) {
        int id = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] + i >= id){
                id = i;
            }
        }
        return id == 0;
    }
}
