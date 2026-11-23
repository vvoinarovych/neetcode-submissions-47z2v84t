class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return rec(s, 0, wordDict, new Boolean[s.length()]);
    }
    //return if string starting from give id can be splat fully on words from dictionary
    private boolean rec(String s, int id, List<String> wordDict, Boolean[] cache){
        if(id == s.length()){
            return true;
        }
        if(cache[id] != null){
            return cache[id];
        }
        boolean result = false;
        for(String w : wordDict){
            if(s.startsWith(w, id)){
                if(rec(s, id + w.length(), wordDict, cache)){
                    result = true;
                    break;
                }
            }
        }
        cache[id] = result;
        return result;
    }
}
