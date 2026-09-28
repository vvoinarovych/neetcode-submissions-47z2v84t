class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int maxL = 0;
        int n = s.length();
        //c a b a c
        boolean[][] cache = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || cache[i + 1][j - 1])){
                    cache[i][j] = true;
                    if(j - i + 1 > maxL){
                        maxL = j - i + 1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }
}
