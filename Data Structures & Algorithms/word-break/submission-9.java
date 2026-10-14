class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] cache = new Boolean[s.length() + 1];
        return rec(s.length(), s, wordDict, cache);
    }
    //can split first id elements on dict words?
    private boolean rec(int id, String s, List<String> dict, Boolean[] cache){
        if(id == 0){
            return true;
        }
        if(cache[id] != null){
            return cache[id];
        }
        boolean result = false;
        for(String w : dict){
            if(s.startsWith(w, id - w.length())){
                if(rec(id - w.length(), s, dict, cache)){
                    result = true;
                    break;
                }
            }
        }
        cache[id] = result;
        return result;
    }
}
