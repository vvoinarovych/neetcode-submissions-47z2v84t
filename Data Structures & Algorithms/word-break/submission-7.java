class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return rec(s.length(), s, wordDict, new Boolean[s.length() + 1]);
    }
    //can first 8 elements be split on words from dict
    private boolean rec(int i, String s, List<String> wordDict, Boolean[] cache){
        if(i == 0) return true;
        if(cache[i] != null) return cache[i];

        boolean result = false;
        for(String w : wordDict){
            if(s.startsWith(w, i - w.length())){
                if(rec(i - w.length(), s, wordDict, cache)){
                    result = true;
                    break;
                }
            }
        }
        cache[i] = result;
        return cache[i];
    }
}
