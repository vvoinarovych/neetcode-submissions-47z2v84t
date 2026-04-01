class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {  
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);      
        int[] result = new int[nums.length - k + 1];
        
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            q.offer(new int[]{nums[i], i});
            if(i >= k - 1){
                while(q.peek()[1] <= i - k){
                    q.poll();
                }
                result[index] = q.peek()[0];
                index++;
            }
        }
        return result;
    }
}
