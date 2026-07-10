class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> pairs = new HashMap<>();
        pairs.put(']', '[');
        pairs.put('}', '{');
        pairs.put(')', '(');
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char b = s.charAt(i);
            if(pairs.containsKey(b)){
                if(dq.peek() == pairs.get(b)){
                    dq.poll();
                }else{
                    return false;
                }
            }else{
                dq.push(b);
            }
        }
        return dq.isEmpty();
    }
}
