class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        int first = nums[0];
        int second = fast;
        while(first != second){
            first = nums[first];
            second = nums[second];
        }
        return first;
    }
}
