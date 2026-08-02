class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0], b[0]));
        int counter = 0;
        //[1,2], [1,4], [2,4]
        int r = intervals[0][1];
        int l = intervals[0][0];
        for(int i = 1; i < intervals.length; i++){
            int[] iv = intervals[i];
            if(iv[0] < r){
                counter++;
                r = Math.min(r, iv[1]);
                l = Math.min(l, iv[0]);
            }else{
                r = iv[1];
                l = iv[0];
            }
        }
        return counter;
    }
}
