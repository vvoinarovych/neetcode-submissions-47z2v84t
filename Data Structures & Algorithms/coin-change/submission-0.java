class Solution {
    int placeholder;
    int[] cache;
    public int coinChange(int[] coins, int amount) {        
        cache = new int[amount + 1];
        Arrays.fill(cache, -1);
        placeholder = amount + 1;
        int result = rec(amount, coins);
        return  result > amount ? -1 : result;
    }

    public int rec(int sum, int[] coins){
        if(sum == 0){
            return 0;
        }
        if(sum < 0){
            return placeholder;
        }

        int result = placeholder;
        if(cache[sum] != -1){
            return cache[sum];
        }

        for(int c : coins){
            result = Math.min(result, rec(sum - c, coins) + 1);
        }
        cache[sum] = result;
        return result;
    }
}
