class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        String result = "";
        var arr = map.get(key);
        int l = 0;
        int r = arr.size() - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(arr.get(mid).key <= timestamp){
                result = arr.get(mid).value;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return result;
    }

    public class Pair{
        Integer key;
        String value;

        public Pair(Integer key, String value){
            this.key = key;
            this.value = value;
        }
    }
}
