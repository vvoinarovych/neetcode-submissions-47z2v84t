class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int l = 0;
        int r = rows * columns - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            int row = mid / columns;
            int col = mid % columns;

            if(matrix[row][col] == target){
                return true;
            }else if(target < matrix[row][col]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}
