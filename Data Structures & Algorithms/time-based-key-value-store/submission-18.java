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
        if(pairs == null) return "";
        int l = 0;
        int r = pairs.size() -1;

        while(l <= r){
            int mid = (l + r) / 2;
            Pair pair = pairs.get(mid);
            
            if(pair.t <= timestamp){
                result = pair.v;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return result;
    }

    public class Pair{
        public int t;
        public String v;

        public Pair(int t, String v){
            this.t = t;
            this.v = v;
        }
    }
}
