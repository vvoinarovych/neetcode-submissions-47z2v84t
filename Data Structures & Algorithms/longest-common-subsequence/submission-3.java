class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        Integer[][] cache = new Integer[n1 + 1][n2 + 1];
        return rec(text1, n1, text2, n2, cache);
    }

    private int rec(String s1, int i1, String s2, int i2, Integer[][] cache){
        if(i1 == 0 || i2 == 0){
            return 0;
        }
        if(cache[i1][i2] != null){
            return cache[i1][i2];
        }

        int result;
        if(s1.charAt(i1 - 1) == s2.charAt(i2 - 1)){
            result = rec(s1, i1 - 1, s2, i2 - 1, cache) + 1;
        }else{
            result = Math.max(rec(s1, i1 - 1, s2, i2, cache), rec(s1, i1, s2, i2 - 1, cache));
        }
        cache[i1][i2] = result;
        return cache[i1][i2];
    }
}
