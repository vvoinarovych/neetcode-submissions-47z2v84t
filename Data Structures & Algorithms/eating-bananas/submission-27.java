class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int min = r;

        while(l <= r){
            int k = (l + r) / 2;
            int time = 0;
            for(int p : piles){
                time += (p + k - 1) / k;
            }

            if(time <= h){
                min = k;
                r = k - 1;
            }else{
                l = k + 1;
            }
        }
        return min;
    }
}
