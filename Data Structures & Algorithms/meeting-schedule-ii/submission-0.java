class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for (Interval iv : intervals) {
            start.add(iv.start);
            end.add(iv.end);
        }
        //0, 5, 15        
        //5, 15, 40
        Collections.sort(start);
        Collections.sort(end);

        int s = 0;
        int e = 0;
        int count = 0;
        int result = 0;

        while (s < start.size()) {
            if (start.get(s) < end.get(e)) {
                count++;
                result = Math.max(result, count);
                s++;
            } else {
                count--;
                e++;
            }
        }

        return result;
    }
}