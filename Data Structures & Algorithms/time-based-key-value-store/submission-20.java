class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        if(map.containsKey(key)){
            List<Pair> list = map.get(key);
            int l = 0;
            int r = list.size() - 1;
            while(l <= r){
                int mid = (l + r) / 2;
                if(list.get(mid).time == timestamp){
                    result = list.get(mid).val;
                    break;
                }
                if(list.get(mid).time >= timestamp){
                    r = mid - 1;
                }else{
                    result = list.get(mid).val;
                    l = mid + 1;
                }
                //1 2 3 4 6 7 8         5
                
            }
        }
        return result;
    }

    class Pair{
        int time;
        String val;

        public Pair(int time, String val){
            this.time = time;
            this.val = val;
        }
    }
}
