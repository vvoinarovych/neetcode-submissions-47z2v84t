class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        for(String s : strs){
            char[] freq = new char[26];
            for(char ch : s.toCharArray()){
                freq[ch - 'a']++;
            }
            String key = String.valueOf(freq);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}
