class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int id = 0;
        List<int[]> result = new ArrayList<>();
        while(id < intervals.length && intervals[id][1] < newInterval[0]){
            result.add(intervals[id]);
            id++;
        }

        while(id < intervals.length && newInterval[1] >= intervals[id][0]){
           
            newInterval[0] = Math.min(newInterval[0], intervals[id][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[id][1]);
            id++;
        }
        result.add(newInterval);

        while(id < intervals.length){
            result.add(intervals[id]);
            id++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
