class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        int first = slow;
        int second = 0;
        while(first != second){
            first = nums[first];
            second = nums[second];
        }
        return first;
    }
}
