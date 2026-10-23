class Solution {
    public int minDistance(String word1, String word2) {
        return count(word1, 0, word2, 0, new Integer[word1.length()][word2.length()]);
    }

    private int count(String w1, int i1, String w2, int i2, Integer[][] cache){
        if(i1 == w1.length()){
            return w2.length() - i2;
        }
        if(i2 == w2.length()){
            return w1.length() - i1;
        }
        if(cache[i1][i2] != null){
            return cache[i1][i2];
        }

        int result;
        if(w1.charAt(i1) == w2.charAt(i2)){
            result = count(w1, i1 + 1, w2, i2 + 1, cache);
        }else{
            //monkeys
            //money
            int insert = count(w1, i1, w2, i2 + 1, cache);
            int remove = count(w1, i1 + 1, w2, i2, cache);
            int replace = count(w1, i1 + 1, w2, i2 + 1, cache);
            result = Math.min(insert, Math.min(remove, replace)) + 1;
        }
        cache[i1][i2] = result;
        return result;
    }
}
