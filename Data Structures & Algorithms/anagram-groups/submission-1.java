class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] count = new char[26];
            for(char ch : s.toCharArray()){
                count[ch - 'a']++;
            }
            String key = String.valueOf(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}

//time O(n * m)
//space O(n * m)
//n - number of strings, m - length of largest string
