class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int left = 0;

        for(int i = 0; i < nums.length; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(dq.peekFirst() < left){
                dq.pollFirst();
            }

            if(i >= k - 1){
                result[left] = nums[dq.peekFirst()];
                left++;
            }
        }
        return result;
    }
}
