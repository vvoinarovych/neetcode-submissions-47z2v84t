class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        Integer[][] cache = new Integer[n][m];
        return rec(text1, 0, text2, 0, cache);
    }

    private int rec(String t1, int i1, String t2, int i2, Integer[][] cache){
        if(i1 == t1.length() || i2 == t2.length()){
            return 0;
        }
        if(cache[i1][i2] != null){
            return cache[i1][i2];
        }

        int result;
        if(t1.charAt(i1) == t2.charAt(i2)){
            result = 1 + rec(t1, i1 + 1, t2, i2 + 1, cache);
        }else{
            result = Math.max(
                rec(t1,i1 + 1, t2, i2, cache),
                rec(t1,i1,t2,i2 + 1, cache)
            );
        }
        cache[i1][i2] = result;
        return result;
    }
}
