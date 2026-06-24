class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lastElementIndex = matrix[0].length-1;
        int firstElementIndex = 0;

        int row = 0;

        while(row < matrix.length){
            if(target >= matrix[row][firstElementIndex] && target <= matrix[row][lastElementIndex]){
                return binarySearch(matrix,row,target);
            }
            row++;
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix,int row,int target){
        int s = 0;
        int e = matrix[row].length-1;

        while(s <= e){
            int m = (s+e)/2;

            if(matrix[row][m] == target){
                return true;
            }

            if(matrix[row][m] < target){
                s = m + 1;
            }
            else{
                e = m - 1;
            }
        }

        return false;
    }
}
