class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        bt(0,0,n, new StringBuilder());
        return result;
    }

    private void bt(int open, int close, int n, StringBuilder sb){
        if(open + close == n * 2){
            result.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append('(');
            bt(open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(')');
            bt(open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
