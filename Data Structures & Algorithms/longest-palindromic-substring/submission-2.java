class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] cache = new boolean[n][n];
        int max = 0;
        int start = -1;

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || cache[i + 1][j - 1])){
                    cache[i][j] = true;
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        start = i;
                    }                    
                }
            }
        }
        return s.substring(start, start + max);
    }
}
