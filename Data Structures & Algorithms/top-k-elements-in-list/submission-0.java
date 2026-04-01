class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1]);
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            pq.add(new int[]{e.getKey(), e.getValue()});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll()[0];
        }
        return result;
    }
}

//time: O(n * log(k))
//space: O(n)
