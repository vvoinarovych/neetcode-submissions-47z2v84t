class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] key = new char[26];
            for(char ch : s.toCharArray()){
                key[ch - 'a']++;
            }
            String k = String.valueOf(key);
            map.computeIfAbsent(k, x -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
