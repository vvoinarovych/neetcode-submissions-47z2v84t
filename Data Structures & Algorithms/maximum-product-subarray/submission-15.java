class Solution {
    public int maxProduct(int[] nums) {
        // if(nums.length == 0){
        //     return 0;
        // }
        // if(nums.length == 1){
        //     return nums[0];
        // }              
        int result = nums[0];       

        int prevMin = nums[0];
        int prevMax = nums[0];

        for(int i = 1; i < nums.length; i++){
            int val = nums[i];
            int min = prevMin * val;
            int max = prevMax * val;

            prevMin = Math.min(val, Math.min(min, max));
            prevMax = Math.max(val, Math.max(min, max));
            result = Math.max(prevMax, result);
        }
        return result;
    }
}
