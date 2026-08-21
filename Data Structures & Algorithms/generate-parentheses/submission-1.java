class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        bt(n, 0, 0, new StringBuffer());
        return result;
    }

    public void bt(int n, int open, int close, StringBuffer sb){
        if(sb.length() == n * 2){
            result.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append('(');
            bt(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(')');
            bt(n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
