class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int l = 0;
        int r = ROWS * COLS - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            int row = mid / COLS;
            int col = mid % COLS;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }
}
