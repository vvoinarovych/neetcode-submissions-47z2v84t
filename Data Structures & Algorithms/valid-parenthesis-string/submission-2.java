class Solution {
    public boolean checkValidString(String s) {
        int worst = 0;
        int best = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                best++;
                worst++;
            }else if(ch == ')'){
                best--;
                worst--;
            }else{
                worst--;
                best++;
            }
            if(best < 0){
                return false;
            }
            if(worst < 0){
                worst = 0;
            }
        }
        return worst == 0;
    }
}
