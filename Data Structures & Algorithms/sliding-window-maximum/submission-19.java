class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int l = 0;        

        for(int r = 0; r < nums.length; r++){
            int numR = nums[r];
            while(!dq.isEmpty() && numR > nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(r);
            if(l > dq.peekFirst()){
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
