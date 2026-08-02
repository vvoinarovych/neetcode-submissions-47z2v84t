class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int r = intervals[0][1];
        int l = intervals[0][0];
        List<int[]> result = new ArrayList<>();
        for(int[] i : intervals){            
            if(r >= i[0]){
                r = Math.max(r, i[1]);
            }else{
                result.add(new int[]{l, r});
                r = i[1];
                l = i[0];
            }
        }
        result.add(new int[]{l , r});
        return result.toArray(new int[result.size()][]);
    }
}
