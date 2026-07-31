class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] cur = new int[3];
        for(int[] t : triplets){
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;

            cur[0] = Math.max(cur[0], t[0]);
            cur[1] = Math.max(cur[1], t[1]);
            cur[2] = Math.max(cur[2], t[2]);
        }
        return Arrays.equals(cur,target);
    }
}
