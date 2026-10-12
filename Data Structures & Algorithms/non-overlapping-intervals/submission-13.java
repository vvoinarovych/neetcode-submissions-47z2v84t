class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int r = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int[] iv = intervals[i];
            if(iv[0] < r){
                count++;
                r = Math.min(r, iv[1]);
            }else{
                r = iv[1];
            }
        }
        return count;
    }
}
