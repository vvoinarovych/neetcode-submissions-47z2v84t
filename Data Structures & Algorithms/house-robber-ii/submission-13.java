class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int start = solve(nums,0, nums.length - 1);
        int end = solve(nums, 1, nums.length);
        return Math.max(start, end);
    }

    private int solve(int[] nums, int start, int end){
        int minus2 = 0;
        int minus1 = nums[start];

        for(int i = start + 1; i < end; i++){
            int now = Math.max(minus1, minus2 + nums[i]);
            minus2 = minus1;
            minus1 = now;
        }
        return minus1;
    }
}
