class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int minimumK = r;

        while(l <= r){
            int k = (l + r) / 2;
            int time = 0;
            for(int pile : piles){
                time += (pile + k - 1) / k;
            }

            if(time <= h){
                minimumK = k;
                r = k - 1;
            }else{
                l = k + 1;;
            }
        }
        return minimumK;
    }
}
