class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        var list = map.get(key);
        if(!map.containsKey(key)){
            return "";
        }
        int l = 0;
        int r = list.size() - 1;
        String result = "";

        //3
        //1 2 3 4 5 6 7 8
        while(l <= r){
            int mid = (l + r) / 2;
            Pair el = list.get(mid);
            
            if(el.k == timestamp){
                return el.v;
            }
            if(el.k < timestamp){
                result = el.v;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return result;
    }

    public class Pair{
        Integer k;
        String v;

        public Pair(Integer k, String v){
            this.k = k;
            this.v = v;
        }
    }
}
