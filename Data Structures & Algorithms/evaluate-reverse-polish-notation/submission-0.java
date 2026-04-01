class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> order = new ArrayDeque<>();
        for(String token : tokens){
            if(isNumber(token)){
                order.push(Integer.parseInt(token));
            }else{
                int b = order.pop();
                int a = order.pop();
                switch(token){
                    case "+" -> order.push(a + b);
                    case "-" -> order.push(a - b);
                    case "*" -> order.push(a * b);
                    case "/" -> order.push(a / b);
                }
            }
        }
        return order.pop();
    }
    private boolean isNumber(String token){
        try{
            Integer.parseInt(token);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}
