class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return count(word1,0,word2,0,new Integer[n][m]);
    }

    private int count(String s1, int i1, String s2, int i2, Integer[][] cache){
        if(i1 == s1.length()){
            return s2.length() - i2;
        }
        if(i2 == s2.length()){
            return s1.length() - i1;
        }
        if(cache[i1][i2] != null){
            return cache[i1][i2];
        }
        int op;
        //doNothing
        if(s1.charAt(i1) == s2.charAt(i2)){
            op = count(s1, i1 + 1, s2, i2 + 1, cache);
        }else{
            //monkey
            //money
            int insert = count(s1,i1,s2,i2 + 1, cache);
            int delete = count(s1,i1+1,s2,i2,cache);
            int replace = count(s1,i1+1,s2,i2+1,cache);
            op = Math.min(insert, Math.min(delete,replace)) + 1; 
        }
        cache[i1][i2] = op;
        return op;
    }
}
