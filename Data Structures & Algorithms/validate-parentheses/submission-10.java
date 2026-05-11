class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(']', '[');
        pairs.put('}', '{');
        pairs.put(')', '(');

        for(char ch : s.toCharArray()){
            if(pairs.containsKey(ch)){
                if(stack.peek() != pairs.get(ch)){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.size() == 0;
    }
}
