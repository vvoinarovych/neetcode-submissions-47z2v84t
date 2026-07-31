class Solution {
    public boolean checkValidString(String s) {
        int w = 0;
        int b = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                w++;
                b++;
            }else if(ch == ')'){
                w--;
                b--;
            }else{
                w--;
                b++;
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
