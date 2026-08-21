class Solution {
    public boolean checkValidString(String s) {
        int b = 0;
        int w = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                b++;
                w++;
            }else if(ch == ')'){
                b--;
                w--;
            }else{
                b++;
                w--;
            }
            if(b < 0){
                return false;
            }
            if(w < 0){
                w = 0;
            }
        }
        return w == 0;
    }
}
