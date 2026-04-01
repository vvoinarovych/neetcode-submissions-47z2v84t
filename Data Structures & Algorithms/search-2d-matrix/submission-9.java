class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        int l = 0;
        int r = cols * rows - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            int row = mid / cols;
            int col = mid % cols;

            if(matrix[row][col] > target){
                r = mid - 1;
            }else if(matrix[row][col] < target){
                l = mid + 1;
            }else{
                return true;
            }
        }
        return false;
        
    }
}
