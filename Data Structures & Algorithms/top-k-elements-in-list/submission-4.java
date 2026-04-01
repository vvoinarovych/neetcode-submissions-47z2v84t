class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] count = new ArrayList[nums.length+1];
        for(var entry : freq.entrySet()){
            int index = entry.getValue();
            int number = entry.getKey();
            if(count[index] == null){
                count[index] = new ArrayList<>();
            }
            count[index].add(number);
        }
        int c = 0;
        int[] result = new int[k];
        for(int i = count.length - 1; i >= 0 && c < k; i--){
            if(count[i] == null){
                continue;
            }
            for(int num : count[i]){
                result[c] = num;
                c++;
                if(c >= k){
                    break;
                }
            }
        }
        return result;
    }
}
