class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while(l < r){
            int num1 = numbers[l];
            int num2 = numbers[r];

            if(num1 + num2 == target){
                return new int[]{l + 1, r + 1};
            }
            if(num1 + num2 > target){
                r--;
            }else{
                l++;
            }
        }
        return new int[2];
    }
}
