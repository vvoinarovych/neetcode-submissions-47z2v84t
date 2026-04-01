class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] keyArr = s.toCharArray();
            Arrays.sort(keyArr);
            String key = String.valueOf(keyArr);

            map.computeIfAbsent(key, v -> new ArrayList<>()).add(s);            
        }
        List<List<String>> result = new ArrayList<>();
        for(var val : map.values()){
            result.add(val);
        }
        return result;
    }
}
