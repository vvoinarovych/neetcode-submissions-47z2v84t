class Solution {
    public int maxProfit(int[] prices) {
        int lowest = prices[0];
        int max = 0;

        for(int p : prices){
            lowest = Math.min(lowest, p);
            max = Math.max(max, p - lowest);
        }
        return max;
    }
}
