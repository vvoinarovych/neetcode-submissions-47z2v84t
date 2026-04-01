class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key)){
            return "";
        }
        var list = map.get(key);
        int l = 0;
        int r = list.size() - 1;
        String result = "";
        while(l <= r){
            int mid = (l + r) / 2;
            if(list.get(mid).k == timestamp){
                return list.get(mid).v;
            }
            if(list.get(mid).k < timestamp){
                result = list.get(mid).v;
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
