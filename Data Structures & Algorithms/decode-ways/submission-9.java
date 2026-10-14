class Solution {
    String s;
    Integer[] cache;
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        this.s = s;
        this.cache = new Integer[s.length() + 1];
        return rec(s.length());
    }
    //"1234" n = 4, start id = 4
    //returns ways to decode first id symbols
    private int rec(int id){
        if(id == 0){
            return 1;
        }
        if(cache[id] != null){
            return cache[id];
        }
        int ways = 0;
        if(s.charAt(id - 1) - '0' > 0){
            ways += rec(id - 1);
        }
        if(id >= 2){
            int two = Integer.parseInt(s.substring(id - 2, id));
            if(two >= 10 && two <= 26){
                ways += rec(id - 2);
            }
        }
        cache[id] = ways;
        return ways;
    }
}
