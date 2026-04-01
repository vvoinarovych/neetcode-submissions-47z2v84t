class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0 ) + 1);
        }
        ArrayList<Integer>[] b = new ArrayList[nums.length + 1];
        for(int i = 0; i < nums.length + 1; i++){
            b[i] = new ArrayList<>();
        }
        

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            b[entry.getValue()].add(entry.getKey());
        }
        //[1,2,3]

        int[] result = new int[k];
        int counter = 0;


        for(int i = b.length - 1; i >= 0 && counter < k; i--){
            for(int n : b[i]){
                result[counter] = n;
                counter++;
                if(counter >= k){
                    break;
                }
            }
        }

        return result;
    }
}
