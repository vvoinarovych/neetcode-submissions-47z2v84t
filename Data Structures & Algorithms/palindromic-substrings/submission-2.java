class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int counter = 0;

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1])){
                    isPalindrome[i][j] = true;
                    counter++;
                }
            }
        }
        return counter;
    }
}
