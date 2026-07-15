class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            int num = nums[mid];

            if(target == num){
                return mid;
            }
            if(target < nums[mid]){
                r = mid - 1;
            }else{
                l = l + 1;
            }
        }
        return -1;
    }
}
