class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] px = new int[nums.length];
        px[0] = 1;
        for(int i = 1; i < nums.length; i++){
            px[i] = px[i - 1] * nums[i - 1];
        }

        int prev = 1;
         for(int i = nums.length - 1; i >= 0; i--){
             px[i] = prev * px[i];
             prev = prev * nums[i];
        }
        return px;
    }
}  
