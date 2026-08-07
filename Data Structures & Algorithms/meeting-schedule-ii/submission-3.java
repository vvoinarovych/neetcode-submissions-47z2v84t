/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for(Interval iv : intervals){
            start.add(iv.start);
            end.add(iv.end);
        }
        Collections.sort(start);
        Collections.sort(end);

        int s = 0;
        int e = 0;
        int rooms = 0;
        int result = 0;
        // 0, 5, 15
        // 10, 20, 40
        while(s < intervals.size()){
            if(start.get(s) < end.get(e)){
                rooms++;
                s++;
                result = Math.max(result, rooms);
            }else{
                rooms--;
                e++;
            }
        }
        return result;
    }
}
