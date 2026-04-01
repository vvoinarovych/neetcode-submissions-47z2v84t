class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while(l <= r){
            int k = (l + r) / 2;
            int time = 0;
            for(int p : piles){
                time += (p + k - 1) / k;
            }

            if(time > h){
                l = k + 1;
            }else{
                r = k - 1;
                res = k;
            }
        }
        return res;
    }
}
