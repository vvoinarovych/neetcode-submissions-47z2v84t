class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] cache = new Integer[n][2];
        return count(0, false, prices, cache);
    }

    private int count(int day, boolean have, int[] prices, Integer[][] cache){        
        int hold = have ? 1 : 0;
        if(day >= prices.length){
            return 0;
        }
        if(cache[day][hold] != null){
            return cache[day][hold];
        }
        int result = count(day + 1, have, prices, cache);
        if(have){
            int sell = count(day + 2, false, prices, cache) + prices[day];
            result = Math.max(result,sell);
        }else{
            int buy = count(day + 1, true, prices, cache) - prices[day];
            result = Math.max(result, buy);
        }
        cache[day][hold] = result;
        return result;
    }
}
