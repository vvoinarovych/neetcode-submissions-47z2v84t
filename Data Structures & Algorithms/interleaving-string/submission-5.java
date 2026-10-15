class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        return rec(s1, 0, s2, 0, s3, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    private boolean rec(String s1, int i1, String s2, int i2, String s3, Boolean[][] cache){
        if(i1 + i2 == s3.length()){
            return true;
        }        
        if(cache[i1][i2] != null){
            return cache[i1][i2];
        }
        char ch = s3.charAt(i1 + i2);
        boolean result;
        
        result = (i1 < s1.length() && s1.charAt(i1) == ch && rec(s1, i1 + 1, s2, i2, s3, cache)) ||
                (i2 < s2.length() && s2.charAt(i2) == ch && rec(s1, i1, s2, i2 + 1, s3, cache));
        cache[i1][i2] = result;
        return result;
    }
}
