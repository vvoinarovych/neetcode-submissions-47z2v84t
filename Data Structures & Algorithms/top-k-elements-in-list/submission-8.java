class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(var entry : count.entrySet()){
            int num = entry.getKey();
            int qty = entry.getValue();
            if(bucket[qty] == null){
                bucket[qty] = new ArrayList<>();
            }
            bucket[qty].add(num);
        }
        int[] result = new int[k];
        int id = 0;
        for(int i = bucket.length - 1; i >= 0 && id < k; i--){
            if(bucket[i] == null) continue;
            var list = bucket[i];
            for(int num : list){
                result[id] = num;
                id++;
                if(id > k){
                    break;
                }
            }
        }
        return result;
    }
}
