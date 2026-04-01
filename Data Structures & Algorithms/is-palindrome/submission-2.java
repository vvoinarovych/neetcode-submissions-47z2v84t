class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r){

            while(l < r && !isValidChar(s.charAt(l))){
                l++;
            }
            while(l < r && !isValidChar(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            r--;
            l++;
        }
        return true;
    }

    public boolean isValidChar(char ch){
        return (ch >= 'a' && ch <= 'z') ||
                (ch >= 'A' && ch <= 'Z') ||
                (ch >='0' && ch <= '9');
    }
}
