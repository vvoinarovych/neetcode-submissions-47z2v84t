class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int r = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < r){
               count++;
               r = Math.min(r, intervals[i][1]);
            }else{
                r = intervals[i][1];
            }
        }
        return count;
    }
}
