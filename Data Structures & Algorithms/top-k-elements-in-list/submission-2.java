class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            if(bucket[val] == null){
                bucket[val] = new ArrayList<>();
                bucket[val].add(key);
            }else{
                bucket[val].add(key);
            }
        }
        int count = 0;
        int[] result = new int[k];
        for(int i = bucket.length - 1; i >=0 && count < k; i--){
            if(bucket[i] != null){
                for(Integer n : bucket[i]){
                    result[count] = n;
                    count++;
                    if(count >= k){
                        break;
                    }
                }
            }
        }
        return result;
    }
}
