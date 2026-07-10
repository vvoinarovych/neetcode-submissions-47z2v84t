class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(String token : tokens){
            switch(token){
                case "+" -> dq.push(dq.pop() + dq.pop());
                case "*" -> dq.push(dq.pop() * dq.pop());
                case "-" -> {
                    int b = dq.pop();
                    int a = dq.pop();
                    dq.push(a - b);
                }
                case "/" -> {
                    int b = dq.pop();
                    int a = dq.pop();
                    dq.push(a / b);
                }
                default -> dq.push(Integer.parseInt(token));
            }
        }
        return dq.peek();
    }
}
