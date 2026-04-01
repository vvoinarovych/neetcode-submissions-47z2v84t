class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] combo = new double[position.length][2];
        for(int i = 0; i < position.length; i++){
            combo[i][0] = position[i];
            combo[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(combo, (a, b) -> Double.compare(b[0], a[0]));

        int fleet = 1;
        double prev = combo[0][1];
        for(int i = 1; i < position.length; i++){
            if(combo[i][1] > prev){
                fleet++;
                prev = combo[i][1];
            }
        }
        return fleet;
    }
}
