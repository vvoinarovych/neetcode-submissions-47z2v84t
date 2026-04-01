class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] cs1 = new char[26];
        for(char ch : s1.toCharArray()){
            cs1[ch -'a']++;
        }
        int l = 0;
        char[] cs2 = new char[26];
        for(int r = 0; r < s2.length(); r++){
            cs2[s2.charAt(r) - 'a']++;
            while(r - l + 1 > s1.length()){
                cs2[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(cs1, cs2)){
                return true;
            }
        }
        return false;
    }
}
