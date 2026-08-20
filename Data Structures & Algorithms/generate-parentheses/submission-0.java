class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        bt(new StringBuilder(), 0, 0, n);
        return result;
    }

    void bt(StringBuilder sub, int open, int close, int n){
        if(sub.length() == n * 2){
            result.add(sub.toString());
            return;
        }
        if(open < n){
            sub.append('(');
            bt(sub, open + 1, close, n);
            sub.deleteCharAt(sub.length() - 1);
        }
        if(close < open){
            sub.append(')');
            bt(sub, open, close + 1, n);
            sub.deleteCharAt(sub.length() - 1);
        }       
    }
}
