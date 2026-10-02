class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] isValid = new boolean[n][n];

        for(int i = n; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j-i < 2 || isValid[i + 1][j - 1])){
                    isValid[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
