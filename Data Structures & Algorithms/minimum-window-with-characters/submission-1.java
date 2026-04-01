class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        for(char ch : t.toCharArray()){
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int need = target.size();
        int have = 0;
        int min = Integer.MAX_VALUE;
        int l = 0;
        int[] res = new int[2]; 

        for(int  r = 0; r < s.length(); r++){
            char cr = s.charAt(r);
            window.put(cr, window.getOrDefault(cr, 0) + 1);

            if(target.containsKey(cr) && target.get(cr).equals(window.get(cr))){
                have++;
            }

            while(have == need){

                if(r -l + 1 < min){
                    min = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char cl = s.charAt(l);
                window.put(cl, window.get(cl) - 1);

                if(target.containsKey(cl) && window.get(cl) < target.get(cl)){
                    have--;
                }
                l++;
            }
        }
        return min == Integer.MAX_VALUE? "" : s.substring(res[0], res[1] + 1);
    }
}
