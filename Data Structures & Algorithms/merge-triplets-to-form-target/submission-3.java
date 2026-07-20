class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] first = new int[3];
        for(int[] t : triplets){
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;
            first[0] = Math.max(first[0], t[0]);
            first[1] = Math.max(first[1], t[1]);
            first[2] = Math.max(first[2], t[2]);
        }
        return Arrays.equals(first, target);
    }
}
