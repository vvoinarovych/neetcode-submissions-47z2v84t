class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        int result = max;
        while(min < max){
            int k = (min + max) / 2;
            int time = 0;
            for(int pile : piles){
                time += (pile + k - 1) / k;
            }

            if(time <= h){
                max = k;
                result = k;
            }else{
                min = k + 1;
            }
        }
        return result;
    }
}
