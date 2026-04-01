class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] key = new char[26];
            for(char ch : s.toCharArray()){
                key[ch - 'a']++;
            }
            String keyS = String.valueOf(key);
            map.computeIfAbsent(keyS, v -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
