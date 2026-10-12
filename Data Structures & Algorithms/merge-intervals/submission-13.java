class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int r = intervals[0][1];
        int l = intervals[0][0];

        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];           

            if(cur[0] <= r){
                r = Math.max(cur[1], r);
            }else{
                result.add(new int[]{l, r});
                l = cur[0];
                r = cur[1];
            }
        }
        result.add(new int[]{l,r});
        return result.toArray(new int[result.size()][2]);
    }
}
