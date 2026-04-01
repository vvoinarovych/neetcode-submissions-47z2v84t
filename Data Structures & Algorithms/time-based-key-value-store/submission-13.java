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
        if(list == null){
            return "";
        }
        int l = 0;
        int r = list.size();
        String result = "";

        while(l < r){
            int mid = (l + r) / 2;
            int el = list.get(mid).ts;
            if(timestamp == el){
                return list.get(mid).val;
            }else if(timestamp > el){
                result = list.get(mid).val;
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return result;
    }

    public class Pair{
        Integer ts;
        String val;

        public Pair(Integer ts, String val){
            this.ts = ts;
            this.val = val;
        }
    }
}
