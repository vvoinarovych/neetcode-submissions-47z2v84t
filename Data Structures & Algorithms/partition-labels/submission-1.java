class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int end = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count++;
            int ch = map.get(s.charAt(i));
            end = Math.max(end, ch);
            if(i == end){
                result.add(count);
                count = 0;
            }
        }
        return result;
    }
}
