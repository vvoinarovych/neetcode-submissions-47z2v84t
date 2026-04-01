class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;        
        // 1, -1
        for(int r = 0; r < nums.length; r++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]){
                dq.pollLast();
            }
            dq.offerLast(r);

            if(!dq.isEmpty() && dq.peekFirst() < index){
                dq.pollFirst();                
            }

            if(r >= k - 1){
                result[index] = nums[dq.peekFirst()];
                index++;
            }
        }
        return result;
    }
}
