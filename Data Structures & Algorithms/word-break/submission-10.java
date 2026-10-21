class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        return rec(s, n, wordDict, new Boolean[n+1]);
    }

    private boolean rec(String s, int len, List<String> dict, Boolean[] cache){
        if(len == 0){
            return true;
        }

        if(cache[len] != null){
            return cache[len];
        }
        boolean result = false;
        for(String w : dict){
            if(s.startsWith(w, len - w.length())){
                if(rec(s, len - w.length(), dict, cache)){
                    result = true;
                    break;
                }
            }
        }
        cache[len] = result;
        return result;
    }
}
