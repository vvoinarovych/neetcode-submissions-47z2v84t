class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(0,0,n,new StringBuilder());
        return result;
    }

    private void generate(int open, int close, int n, StringBuilder sb){
        if(open + close == n * 2){
            result.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            generate(open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(")");
            generate(open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
