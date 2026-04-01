class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(var pair : count.entrySet()){
            int c = pair.getValue();
            int number = pair.getKey();
            if(bucket[c] == null){
                bucket[c] = new ArrayList<>();
                bucket[c].add(number);
            }else{
                bucket[c].add(number);
            }        
        }
        int[] result = new int[k];
        int counter = 0;
        for(int i = bucket.length - 1; i>= 0 && counter < k; i--){
            if(bucket[i] == null){
                continue;
            }
            for(int num: bucket[i]){
                result[counter] = num;
                counter++;
                if(counter >= k){
                    break;
                }
            }
        }
        return result;
    }
}
