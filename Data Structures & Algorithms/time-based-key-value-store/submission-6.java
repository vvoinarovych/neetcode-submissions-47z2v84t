class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        var list = map.get(key);
        String res = "";
        if(!map.containsKey(key)){
            return "";
        }
        int l = 0;
        int r = list.size() - 1;
        while(l <= r){
            int mid = (l + r) / 2;

            if(list.get(mid).k == timestamp){
                return list.get(mid).v;
            }else if(list.get(mid).k <= timestamp){
                l = mid + 1;
                res = list.get(mid).v;
            }else{
                r = mid - 1;
            }
        }
        return res;
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
