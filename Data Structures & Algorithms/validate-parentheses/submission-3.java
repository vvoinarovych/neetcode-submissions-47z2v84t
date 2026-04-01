class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && map.containsKey(ch)){
                if(map.get(ch) == stack.peek()){
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
