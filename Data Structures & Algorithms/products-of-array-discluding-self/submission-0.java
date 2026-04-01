class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        l[0] = 1;
        l[1] = nums[0];
        for(int i = 2; i < nums.length; i++){
            l[i] = nums[i - 1] * l[i - 1];
        }
        int[] r = new int[nums.length];
        r[nums.length - 1] = 1;
        r[nums.length - 2] = nums[nums.length - 1];
        for(int i = nums.length - 3; i >= 0; i--){
            r[i] = nums[i + 1] * r[i + 1];
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = l[i] * r[i];
        }
        return result;
        //[1, 1, 2,8]
        //[48,24,6,1]
    }
}  
