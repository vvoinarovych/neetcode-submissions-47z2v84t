class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] combo = new double[position.length][2];
        for(int i = 0; i < position.length; i++){
            combo[i] = new double[]{position[i], (double)(target - position[i]) / speed[i]};
        }
        Arrays.sort(combo, (a, b) -> Double.compare(b[0], a[0]));
        double prev = combo[0][1];
        int fleet = 1;
        for(double[] c : combo){
            double time = c[1];
            if(time > prev){
                fleet++;
                prev = time;
            }
        }
        return fleet;
    }
}
