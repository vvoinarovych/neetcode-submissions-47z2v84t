class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sg = Arrays.stream(gas).sum();
        int sc = Arrays.stream(cost).sum();
        if(sg < sc) return -1;
        int l = 0;
        int sum = 0;
        for(int r = 0; r < gas.length; r++){
            sum += gas[r] - cost[r];
            if(sum < 0){
                sum = 0;
                l = r + 1;
            }
        }
        return l;
    }
}
