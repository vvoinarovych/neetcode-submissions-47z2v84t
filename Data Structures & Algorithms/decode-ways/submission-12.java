class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0){
            return 1;
        }
        if(s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            int toAdd = 0;
            if(s.charAt(i-1) != '0'){
                toAdd+= dp[i - 1];
            }
            int two = Integer.parseInt(s.substring(i - 2, i));
            if(two >= 10 && two <= 26){
                toAdd+=dp[i-2];
            }
            dp[i] = toAdd;
        }
        return dp[n];
    }
}
