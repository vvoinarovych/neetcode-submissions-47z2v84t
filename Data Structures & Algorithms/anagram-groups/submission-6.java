class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        for(String s : strs){
            char[] count = new char[26];
            for(char ch : s.toCharArray()){
                count[ch - 'a']++; 
            }
            String key = String.valueOf(count);
            groups.computeIfAbsent(key, v -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }
}
