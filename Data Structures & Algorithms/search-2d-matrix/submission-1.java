class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = (matrix.length * matrix[0].length) - 1;
        int cols = matrix[0].length;

        while(l <= r){
            int mid = (l + r) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int num = matrix[row][col];
            if(num > target){
                r = mid - 1;
            }else if(num < target){
                l = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
