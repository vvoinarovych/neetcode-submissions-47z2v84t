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
        if(!map.containsKey(key)) return result;
        var list = map.get(key);
        int l = 0;
        int r = list.size() - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(list.get(mid).t == timestamp){
                return list.get(mid).v;
            // 1 2 3 4 6 8 9
            }else if(timestamp > list.get(mid).t){
                l = mid + 1;
                result = list.get(mid).v;
            }else{
                r = mid - 1;                
            }
        }

        return result;
    }
    record Pair(int t, String v){}
}
