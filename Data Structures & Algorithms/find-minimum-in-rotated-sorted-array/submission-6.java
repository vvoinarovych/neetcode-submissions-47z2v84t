class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if(nums[l] < nums[r]){
            return nums[0];
        }

        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
