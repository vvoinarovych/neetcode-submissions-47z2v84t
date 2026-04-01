class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int l = 0;
        for(int r = 0; r < nums.length; r++){            
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[r]){
                dq.pollLast();
            }
            dq.offerLast(r);

            if(l > dq.peekFirst()){
                dq.pollFirst();
            }

            if(r + 1 >= k){
                result[l] = nums[dq.getFirst()];
                l++;
            }
        }
        return result;
    }
}
