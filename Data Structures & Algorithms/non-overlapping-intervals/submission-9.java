class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int count = 0;        
        int r = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int[] iv = intervals[i];
            if(iv[0] < r){
                r = Math.min(r, iv[1]);
                count++;
            }else{
                r = iv[1];
            }
        }
        return count;
    }
}
