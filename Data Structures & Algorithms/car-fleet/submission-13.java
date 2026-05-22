class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] combo = new double[position.length][2];
        for(int i = 0; i < position.length; i++){
            int pos = position[i];
            double time = (double)(target - pos) /speed[i];
            combo[i] = new double[]{pos, time};
        }
        Arrays.sort(combo, (a, b) -> Double.compare(b[0], a[0]));
        Deque<double[]> stack = new ArrayDeque<>();
        int fleet = 0;
        double prev = 0;
        for(double[] pair : combo){
            double spd = pair[1];
            while(spd > prev){
                fleet++;
                prev = spd;
            }
        }
        return fleet;
    }
}
