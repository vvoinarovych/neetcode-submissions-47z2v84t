class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put('}', '{');
        pair.put(')', '(');
        pair.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && pair.containsKey(ch)){
               if(pair.get(ch) == stack.peek()){
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
