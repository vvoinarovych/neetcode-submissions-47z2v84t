class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] cache = new int[s.length() + 1];
        return rec(0, s, wordDict, cache);
    }

    private boolean rec(int idx, String s, List<String> wordDict, int[] cache){
        if(idx == s.length()) return true;
        if(cache[idx] != 0) return cache[idx] == 1;        
        int result = -1;

        for(String w : wordDict){
            if(s.startsWith(w, idx)){
                boolean recResult = rec(idx + w.length(), s, wordDict, cache);
                if(recResult){
                    result = 1;
                    break;
                }
            }
        }
        
            cache[idx] = result;
        
        return cache[idx] == 1;
    }
}
