class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int prev2 = 0; // id -1
        int prev1 = 1; // id 0

        for (int i = 1; i <= n; i++) {
            int ways = 0;
            int takeOne = s.charAt(i - 1);
            if (takeOne != '0') {
                ways += prev1;
            }
            if (i >= 2) {
                int takeTwo = Integer.parseInt(s.substring(i - 2, i));
                if (takeTwo >= 10 && takeTwo <= 26) {
                    ways += prev2;
                }
            }

            prev2 = prev1;
            prev1 = ways;
        }
        return prev1;
    }
}
