class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                min++;
                max++;
            }else if(ch == ')'){
                max--;
                min--;
            }else{
                max--;
                min++;
            }
            if(min < 0) return false;
            if(max < 0){
                max = 0;
            }
        }
        return max == 0;
    }
}
