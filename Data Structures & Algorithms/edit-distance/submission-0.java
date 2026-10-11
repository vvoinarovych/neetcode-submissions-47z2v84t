class Solution {
    public int minDistance(String word1, String word2) {
        return rec(word1, 0, word2, 0, new Integer[word1.length()][word2.length()]);
    }

    // return minimum operations to make n and m first letters equeal
    private int rec(String w1, int i1, String w2, int i2, Integer[][] cache) {
        if (i1 >= w1.length()) {
            return w2.length() - i2;
        }
        if (i2 >= w2.length()) {
            return w1.length() - i1;
        }
        if (cache[i1][i2] != null)
            return cache[i1][i2];

        int result = Integer.MAX_VALUE;
        if (w1.charAt(i1) == w2.charAt(i2)) {
            result = rec(w1, i1 + 1, w2, i2 + 1, cache);
        } else {
            result = Math.min(rec(w1, i1 + 1, w2, i2 + 1, cache) + 1,
                Math.min(result,
                    Math.min(rec(w1, i1 + 1, w2, i2, cache), rec(w1, i1, w2, i2 + 1, cache)))
                    + 1);
        }
        cache[i1][i2] = result;
        return result;
    }
}
