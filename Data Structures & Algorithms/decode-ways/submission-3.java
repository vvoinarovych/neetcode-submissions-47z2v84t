class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0') return 0;
        if(n == 1) return 1;
        int cache[] = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for(int i = 2; i < cache.length; i++){
            int sum = 0;

            if(s.charAt(i - 1) - '0' > 0){
                sum += cache[i - 1]; 
            }
            int take2 = Integer.parseInt(s.substring(i - 2, i));
            if(take2 >=10 && take2 <= 26){
                sum += cache[i - 2];
            }
            cache[i] = sum;
        }
        return cache[cache.length - 1];
    }
}
