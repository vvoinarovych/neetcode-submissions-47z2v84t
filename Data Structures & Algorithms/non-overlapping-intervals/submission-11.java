class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int counter = 0;
        int r = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int[] iv = intervals[i];
            if(iv[0] < r){
                counter++;
                r = Math.min(iv[1], r);
            }else{
                r = iv[1];
            }
        }
        return counter;
    }
}
