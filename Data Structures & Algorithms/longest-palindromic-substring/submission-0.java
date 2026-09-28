class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int maxL = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                int l = i;
                int r = j;
                while(l < r && s.charAt(l) == s.charAt(r)){
                    r--;
                    l++;
                }
                if(l >= r && maxL < j - i + 1){
                    res = s.substring(i, j+1);
                    maxL = j - i + 1;
                }
            }
        }
        return res;
    }
}
