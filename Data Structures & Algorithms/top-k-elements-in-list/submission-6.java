class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(var entry : count.entrySet()){
            int number = entry.getKey();
            int qty = entry.getValue();
            if(bucket[qty] == null){
                bucket[qty] = new ArrayList<>();
            }
            bucket[qty].add(number);
        }

        int[] result = new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i >= 0 && index < k; i--){
            if(bucket[i] == null){
                continue;
            }
            for(int num : bucket[i]){
                result[index] = num;
                index++;
                if(index >= k){
                    break;
                }
            }
        }
        return result;   
    }
}
