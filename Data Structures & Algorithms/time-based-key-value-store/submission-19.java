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
        String result = "";
        var list = map.get(key);
        int l = 0;
        int r = list.size() - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(list.get(mid).t == timestamp){
                return list.get(mid).v;
            }
            if(list.get(mid).t <= timestamp){
                result = list.get(mid).v;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return result;
    }

    public class Pair{
        int t;
        String v;

        public Pair(int t, String v){
            this.t = t;
            this.v = v;
        }
    }
}
