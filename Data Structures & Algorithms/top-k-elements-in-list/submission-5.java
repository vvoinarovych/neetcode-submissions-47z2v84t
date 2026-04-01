class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(var pair : freq.entrySet()){
            int val = pair.getKey();
            int index = pair.getValue();
            if(bucket[index] == null){
                bucket[index] = new ArrayList<>();
            }
            bucket[index].add(val);
        }
        int[] result = new int[k];
        int curIndex = 0;
        for(int i = bucket.length - 1; i >= 0 && curIndex < k; i--){
            if(bucket[i] == null){
                continue;
            }
            for(int num : bucket[i]){
                result[curIndex] = num;
                curIndex++;
                if(curIndex >= k){
                    return result;
                }
            }
        }
        return result;
    }
}
