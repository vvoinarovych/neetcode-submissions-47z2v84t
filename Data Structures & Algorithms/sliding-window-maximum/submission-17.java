class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int l = 0;
        for(int i = 0; i < nums.length; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(dq.peekFirst() < l){
                dq.pollFirst();
            }

            if(i >= k - 1){
                result[l] = nums[dq.peekFirst()];
                l++;
            }
        }
        return result;
    }
}
