class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        return rec(s1, s2, s3, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    private boolean rec(String s1, String s2, String s3, int i1, int i2, Boolean[][] cache) {
        if (i1 + i2 == s3.length()) {
            return true;
        }        
        if (cache[i1][i2] != null) {
            return cache[i1][i2];
        }
        char c = s3.charAt(i1 + i2);
        boolean one = i1 < s1.length() && s1.charAt(i1) == c && rec(s1, s2, s3, i1 + 1, i2, cache);
        boolean two = i2 < s2.length() && s2.charAt(i2) == c && rec(s1, s2, s3, i1, i2 + 1, cache);

        cache[i1][i2] = one || two;
        return cache[i1][i2];
    }
}
