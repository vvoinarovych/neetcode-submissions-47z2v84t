class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        boolean[][] valid = new boolean[l][l];
        int max = 0;
        int maxStart = 0;

        for(int i = l - 1; i >= 0; i--){
            for(int j = i; j < l; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || valid[i + 1][j - 1])){
                    valid[i][j] = true;
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        maxStart = i;
                    }
                }
            }
        } 
        return s.substring(maxStart, maxStart + max);
    }
}
