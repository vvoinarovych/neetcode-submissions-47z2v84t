class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1count = new int[26];
        for(char ch : s1.toCharArray()){
            s1count[ch - 'a']++;
        }
        int[] s2count = new int[26];
        int l = 0;
        for(int r = 0; r < s2.length(); r++){
            s2count[s2.charAt(r) - 'a']++;

            while(r - l + 1 > s1.length()){
                s2count[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(s1count, s2count)){
                return true;
            }
        }
        return false;
    }
}
