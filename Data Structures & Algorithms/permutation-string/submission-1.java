class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] count1 = new char[26];
        char[] count2 = new char[26];
        for(char ch : s1.toCharArray()){
            count1[ch - 'a']++;
        }
        int l = 0;
        for(int r = 0; r < s2.length(); r++){
            count2[s2.charAt(r) - 'a']++;
            while(r - l + 1 > s1.length()){
                count2[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(count1, count2)){
                return true;
            }            
        }
        return false;
    }
}
