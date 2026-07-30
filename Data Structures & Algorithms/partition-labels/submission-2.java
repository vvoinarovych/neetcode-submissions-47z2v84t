class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }
        int end = 0;
        int id = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            id++;
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));
            if(i == end){
                result.add(id);
                id = 0;
            }
        }
        return result;
    }
}
