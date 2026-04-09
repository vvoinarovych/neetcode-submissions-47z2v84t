class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int mostF = 0;
        int l = 0;
        int max = 0;

        for(int r = 0; r < s.length(); r++){
            count[s.charAt(r) - 'A']++;
            mostF = Math.max(mostF, count[s.charAt(r) - 'A']);
            while(r - l + 1 - mostF > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(r - l + 1, mostF);
        }
        return max;
    }
}
