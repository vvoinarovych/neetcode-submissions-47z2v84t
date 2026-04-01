class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(']', '[');
        pairs.put(')', '(');
        pairs.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(pairs.containsKey(ch)){
                if(!stack.isEmpty() && pairs.get(ch) == stack.peek()){
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
