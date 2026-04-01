class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(dq.peekFirst() < index){
                dq.pollFirst();
            }

            if(i >= k - 1){
                result[index] = nums[dq.peekFirst()];
                index++;
            }
        }
        return result;
    }
}
