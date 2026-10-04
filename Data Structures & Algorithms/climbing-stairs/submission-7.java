class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return rec(n, cache);
    }

    int rec(int stair, int[] cache){
        if(stair <= 1) return 1;
        if(cache[stair] != -1) return cache[stair];
        cache[stair] = rec(stair - 1, cache) + rec(stair - 2, cache);
        return cache[stair];
    }
}
