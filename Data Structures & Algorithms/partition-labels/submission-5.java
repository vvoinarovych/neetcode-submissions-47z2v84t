class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int l = 0;
        int id = -1;
        for(int i = 0; i < s.length(); i++){
            id = Math.max(id, map.get(s.charAt(i)));
            if(id == i){
                result.add(i - l + 1);
                l = id + 1;
            }
        }
        return result;
    }
}
