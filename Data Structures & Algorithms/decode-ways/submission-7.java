class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int n = s.length();
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;

        for(int i = 2; i <= n; i++){
            int ways = 0;
            int take1 = s.charAt(i - 1) - '0';
            if(take1 > 0){
                ways += cache[i-1];
            }
            int take2 = Integer.parseInt(s.substring(i - 2, i));
            if(take2 >= 10 && take2 <= 26){
                ways += cache[i-2];
            }
            cache[i] = ways;
        }
        return cache[cache.length - 1];
    }
}
