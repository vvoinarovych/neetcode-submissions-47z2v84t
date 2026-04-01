class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            char cl = Character.toLowerCase(s.charAt(l));
            char cr = Character.toLowerCase(s.charAt(r));
            while(!isValid(cl) && l < r){
                l++;    
                cl = Character.toLowerCase(s.charAt(l));    
            }
            while(!isValid(cr) && l < r){
                r--;        
                cr = Character.toLowerCase(s.charAt(r));
            }
            if(cl != cr){
                return false;
            }
            l++;
            r--;

        }
        return true;
    }

    public boolean isValid(char c){
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9'
        );
    }
}
