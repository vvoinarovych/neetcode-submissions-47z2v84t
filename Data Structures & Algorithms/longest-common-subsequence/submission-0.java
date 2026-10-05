class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length() + 1][text2.length() + 1];
        return rec(text1, text2, text1.length(), text2.length(), memo);
    }

    private int rec(String s1, String s2, int i1, int i2, Integer[][] memo) {
        if (i1 == 0 || i2 == 0)
            return 0;
        if(memo[i1][i2] != null) return memo[i1][i2];
        int result;
        if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
            result = 1 + rec(s1, s2, i1 - 1, i2 - 1, memo);
        } else {
            result = Math.max(rec(s1, s2, i1 - 1, i2, memo), rec(s1, s2, i1, i2 - 1, memo));
        }
        memo[i1][i2] = result;
        return memo[i1][i2];
    }
}
