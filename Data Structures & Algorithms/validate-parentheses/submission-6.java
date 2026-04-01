class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('}', '{');
        pairs.put(')', '(');
        pairs.put(']', '[');
        for(char ch : s.toCharArray()){
            if(pairs.containsKey(ch) && !stack.isEmpty()){
                if(!stack.isEmpty() && stack.peek() == pairs.get(ch)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
stack.push(ch);
            }
            
        }
        return stack.isEmpty();
    }
}
