class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];
            for(char ch : str.toCharArray()){
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, v -> new ArrayList<>()).add(str);
        }
        for(var pair : map.entrySet()){
            result.add(pair.getValue());
        }
        return result;
    }
}
