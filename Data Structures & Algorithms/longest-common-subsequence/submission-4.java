class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int s1 = text1.length();
        int s2 = text2.length();
        Integer[][] cache = new Integer[s1 + 1][s2 + 1];
        return rec(text1, 0, text2, 0, cache);
    }
    //return max common subsequence for first i1 and i2 elements in given strings
    private int rec(String s1, int i1, String s2, int i2, Integer[][] cache){
        if(i1 == s1.length() || i2 == s2.length()){
            return 0;
        }
        if(cache[i1][i2] != null){
            return cache[i1][i2];
        }

        int result;
        if(s1.charAt(i1) == s2.charAt(i2)){
            result = rec(s1, i1 + 1, s2, i2 + 1, cache) + 1;
        }else{
            result = Math.max(rec(s1, i1 + 1, s2, i2, cache), rec(s1, i1, s2, i2 + 1, cache));
        }
        cache[i1][i2] = result;
        return result;
    }
}
