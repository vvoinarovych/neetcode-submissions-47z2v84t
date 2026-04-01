class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] combo = new double[position.length][2];
        for(int i = 0; i < position.length; i++){
            combo[i][0] = position[i];
            combo[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(combo, (a,b) -> Double.compare(b[0], a[0]));

        int fleet = 0;
        double prevTime = 0;
        for(double[] c : combo){
            if(c[1] > prevTime){
                fleet++;
                prevTime = c[1];
            }
        }
        return fleet;
    }
}
