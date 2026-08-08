class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int l = intervals[0][0];
        int r = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            int[] iv = intervals[i];
            if(iv[0] <= r){
                r = Math.max(iv[1], r);
            }else{
                result.add(new int[]{l, r});
                l = iv[0];
                r = iv[1];
            }
        }
        result.add(new int[]{l, r});
        return result.toArray(new int[result.size()][]);
    }
}
