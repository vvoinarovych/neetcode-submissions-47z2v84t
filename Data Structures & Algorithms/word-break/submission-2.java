class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] cache = new boolean[s.length() + 1];
        cache[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            boolean result = false;
            for (String w : wordDict) {
                if (s.startsWith(w, i) && cache[i + w.length()]) {
                    result = true;
                    break;
                }
            }
            cache[i] = result;
        }

        return cache[0];
    }
}
