class Solution {
    public int maxProfit(int[] prices) {
        return count(0, false, prices, new Integer[prices.length][2]);
    }

    private int count(int day, boolean have, int[] prices, Integer[][] cache){
        if(day >= prices.length){
            return 0;
        }
        int haveVal = have ? 1 : 0;
        if(cache[day][haveVal] != null){
            return cache[day][haveVal];
        }
        int result = count(day + 1, have, prices, cache);

        if(have){
            result = Math.max(count(day + 2, false, prices, cache) + prices[day], result);
        }else{
            result = Math.max(count(day + 1, true, prices, cache) - prices[day], result);
        }
        cache[day][haveVal] = result;
        return result;
    }
}
