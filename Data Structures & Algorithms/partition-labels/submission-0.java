class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }
        int end = 0;
        int size = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            size++;
            int ch = map.get(s.charAt(i));
            end = Math.max(end, ch);

            if(i == end){
                result.add(size);
                size = 0;
            }
        }
        return result;
    }
}
