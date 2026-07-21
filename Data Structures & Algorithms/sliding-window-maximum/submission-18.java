class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int l = 0;

        for(int r = 0; r < nums.length; r++){
            while(!dq.isEmpty() && nums[r] > nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(r);
            if(dq.peekFirst() < l){
                dq.pollFirst();
            }
            if(r >= k - 1){
                result[l] = nums[dq.peekFirst()];
                l++;
            }
        }
        return result;
    }
}
