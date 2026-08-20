class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int l = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, map.get(s.charAt(i)));
            l++;
            if(end == i){
                result.add(l);
                l = 0;
            }
        }
        return result;
    }
}
