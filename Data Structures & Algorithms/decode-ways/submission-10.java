class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        return rec(s.length(), s, new Integer[s.length() + 1]);
    }

    private int rec(int id, String s, Integer[] cache) {
        if (id == 0) {
            return 1;
        }
        if (cache[id] != null) {
            return cache[id];
        }

        int ways = 0;
        int takeOne = s.charAt(id - 1);
        if (takeOne != '0') {
            ways += rec(id - 1, s, cache);
        }
        
        if (id >= 2) {
            int takeTwo = Integer.parseInt(s.substring(id - 2, id));
            if (takeTwo >= 10 && takeTwo <= 26) {
                ways += rec(id - 2, s, cache);
            }
        }

        cache[id] = ways;
        return ways;
    }
}
