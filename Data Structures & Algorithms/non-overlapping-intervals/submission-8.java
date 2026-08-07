class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int r = intervals[0][1];
        int counter = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] iv = intervals[i];
            if(r > iv[0]){
                counter++;
                r = Math.min(r, iv[1]);
            }else{
                r = iv[1];
            }
        }
        return counter;

    }
}
