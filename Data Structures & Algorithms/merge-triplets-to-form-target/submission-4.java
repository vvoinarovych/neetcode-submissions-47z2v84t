class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] best = new int[3];
        for(int[] t : triplets){
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;
            best[0] = Math.max(best[0], t[0]);
            best[1] = Math.max(best[1], t[1]);
            best[2] = Math.max(best[2], t[2]);
        }
        return Arrays.equals(best, target);
    }
}
