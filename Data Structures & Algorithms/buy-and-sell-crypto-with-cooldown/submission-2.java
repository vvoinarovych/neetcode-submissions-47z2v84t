class Solution {
    public int maxProfit(int[] prices) {
        return rec(0, false, prices, new Integer[prices.length + 1][2]);
    }

    //return max profit fo using first day days
    private int rec(int day, boolean have, int[] prices, Integer[][] cache){
        int hold = have ? 1 : 0;
        if(day >= prices.length){
            return 0 ;
        }
        if(cache[day][hold] != null){
            return cache[day][hold];
        }
        
        int result = rec(day + 1, have, prices, cache);
        if(!have){
            int buy = rec(day + 1, true, prices, cache) - prices[day];
            result = Math.max(result, buy);
        }else{
            int sell = rec(day + 2, false, prices, cache) + prices[day];
            result = Math.max(result, sell);
        }
        cache[day][hold] = result;
        return result;        
    }
}
