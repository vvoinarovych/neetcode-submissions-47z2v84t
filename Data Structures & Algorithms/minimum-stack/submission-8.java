class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();    
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || min.peek() >= val){
            min.push(val);
        }
    }
    
    public void pop() {
        int pop = stack.pop();
        if(min.peek() == pop){
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
