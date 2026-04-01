class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] combo = new double[position.length][2];
        for(int i = 0; i < position.length; i++){
            double time = (double)(target - position[i]) / speed[i];
            combo[i] = new double[]{position[i], time};
        }
        Arrays.sort(combo, (a,b) -> Double.compare(b[0], a[0]));
        double prev = 0;
        int fleet = 0;
        for(double[] pair : combo){
            double time = pair[1];
            if(time > prev){
                fleet++;
                prev = time;
            }            
        }
        return fleet;
    }
}
