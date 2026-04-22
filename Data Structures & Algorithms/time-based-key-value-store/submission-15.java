class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pairs = map.get(key);        
        String result = "";
        if(pairs == null) return result;
        int l = 0;
        int r = pairs.size() - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(pairs.get(mid).timestamp <= timestamp){
                result = pairs.get(mid).value;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return result;
    }

    class Pair{
        Integer timestamp;
        String value;

        public Pair(Integer timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
