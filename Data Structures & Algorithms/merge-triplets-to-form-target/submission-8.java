class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] result = new int[3];

        for(int[] t : triplets){
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]){
                continue;
            }
            result[0] = Math.max(t[0], result[0]);
            result[1] = Math.max(t[1], result[1]);
            result[2] = Math.max(t[2], result[2]);
        }
        return Arrays.equals(target, result);
    }
}
