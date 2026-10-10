class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] cache = new boolean[n][n];
        int maxL = 0;
        int bestStart = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || cache[i + 1][j - 1])){
                    cache[i][j] = true;
                    if(j - i + 1 > maxL){
                        maxL = j - i + 1;
                        bestStart = i;
                    }
                }
            }
        }    
        return s.substring(bestStart, bestStart + maxL);    
    }
}
