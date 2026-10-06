class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] cache = new int[n+1][amount + 1];
        for(int i = 0; i <= n; i++){
            cache[i][0] = 1;
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j <= amount; j++){
                int result = cache[i + 1][j];
                if(j - coins[i] >= 0){
                    result += cache[i][j - coins[i]];
                }
                cache[i][j] = result;
            }            
        }
        return cache[0][amount];
    }
}
