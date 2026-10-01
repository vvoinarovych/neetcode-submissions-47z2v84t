class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length() + 1];
        return rec(s, 0, wordDict);
    }
    private boolean rec(String s, int id, List<String> dict) {
        if (id == s.length()) return true;
        if(memo[id] != 0){
            return memo[id] == 1;
        }
        int result = -1;
        for (String w : dict) {
            if (s.startsWith(w, id)) {
                if (rec(s, id + w.length(), dict)) {                    
                    result = 1;
                }
            }
        }
        memo[id] = result;
        return memo[id] == 1;
    }
}
