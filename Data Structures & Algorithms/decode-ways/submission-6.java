class Solution {
    public int numDecodings(String s) {
        Integer[] cache = new Integer[s.length() + 1];
        return rec(s.length(), s, cache);
    }
    
    private int rec(int i, String s, Integer[] cache) {
        if (i <= 0)
            return 1;
        if (cache[i] != null)
            return cache[i];

        int ways = 0;
        int one = s.charAt(i - 1) - '0';
        if (one > 0) {
            ways += rec(i - 1, s, cache);
        }
        if (i > 1) {
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two >= 10 && two <= 26) {
                ways += rec(i - 2, s, cache);
            }
        }
        cache[i] = ways;
        return cache[i];
    }
}
