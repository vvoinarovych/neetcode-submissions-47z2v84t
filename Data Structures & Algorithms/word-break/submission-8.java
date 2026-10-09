class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        return rec(0, s, wordDict, new Boolean[n + 1]);
    }

    private boolean rec(int id, String s, List<String> dict, Boolean[] cache){
        if(id == s.length()){
            return true;
        }
        if(cache[id] != null){
            return cache[id];
        }
        
        boolean result = false;
        for(String w : dict){
            if(s.startsWith(w, id)){
                if(rec(id + w.length(),s,dict,cache)){
                    result = true;
                    break;
                }
            }
        }
        cache[id] = result;
        return cache[id];
    }
}
