class Solution {
    public int minDistance(String word1, String word2) {
        return rec(word1, 0, word2, 0, new Integer[word1.length()][word2.length()]);
    }

    private int rec(String s1, int i1, String s2, int i2, Integer[][] cache){
        if(i1 == s1.length()){
            return s2.length() - i2;
        }
        if(i2 == s2.length()){
            return s1.length() - i1;
        }

        if(cache[i1][i2] != null){
            return cache[i1][i2];
        }
        int result;
        //do nothing just go to next symbols
        if(s1.charAt(i1) == s2.charAt(i2)){
            result = rec(s1, i1 + 1, s2, i2 + 1, cache);
        }else{
            int insert = rec(s1, i1, s2, i2 + 1, cache);
            int delete = rec(s1, i1 + 1, s2, i2, cache);
            int replace = rec(s1, i1 + 1, s2, i2 + 1, cache);
            result = Math.min(insert, Math.min(delete, replace)) + 1;
        }
        cache[i1][i2] = result;
        return result;
    }
}
