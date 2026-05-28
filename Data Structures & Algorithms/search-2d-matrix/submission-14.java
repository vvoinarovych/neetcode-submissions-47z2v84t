class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        int cols = matrix[0].length;
        while(l <= r){
            int mid = (l + r) / 2;
            int column = mid % cols;
            int row = mid / cols;

            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}
