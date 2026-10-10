class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0'){
            return 0;
        }
        
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;

        for(int i = 2; i <= n; i ++){
            int ways = 0;
            int takeOne = s.charAt(i - 1) - '0';
            if(takeOne > 0){
                ways += cache[i - 1];
            }

            int takeTwo = Integer.parseInt(s.substring(i - 2, i));
            if(takeTwo >= 10 && takeTwo <= 26){
                ways += cache[i - 2];
            }

            cache[i] = ways;
        }
        return cache[cache.length - 1];
    }
}
