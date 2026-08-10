class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int id = 0;
        List<int[]> res = new ArrayList<>();
        while(id < intervals.length && intervals[id][1] < newInterval[0]){
            res.add(intervals[id]);
            id++;
        }
        //[[1,2],[3,5],[9,10], [13,16]]         - [4,7]
        while(id < intervals.length && newInterval[1] >= intervals[id][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[id][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[id][1]);
            id++;
        }
        res.add(newInterval);

        while(id < intervals.length){
            res.add(intervals[id]);
            id++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
