class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int p : prices){
            min = Math.min(min, p);
            maxProfit = Math.max(maxProfit, p - min);
        }
        return maxProfit;
    }
}
