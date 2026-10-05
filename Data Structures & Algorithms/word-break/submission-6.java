class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] cache = new Boolean[s.length() + 1];
        return rec(s.length(), s, wordDict, cache);
    }
    // returns if we can break word on fragments from index to end of s
    private boolean rec(int id, String s, List<String> wordDict, Boolean[] cache) {
        if (id == 0) {
            return true;
        }
        if(cache[id] != null) return cache[id];

        boolean result = false;
        for (String w : wordDict) {
            int start = id - w.length();
            if(start >= 0 && s.startsWith(w, start) && rec(start, s, wordDict, cache)){
                result = true;
                
                break;
            }
        }
        cache[id] = result;
        return cache[id];
    }
}
