class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int s = 0;
            int e = matrix[i].length-1;

            while(s <= e){
                int m = (s+e)/2;

                if(matrix[i][m] == target){
                    return true;
                }

                if(matrix[i][m] < target){
                    s = m + 1;
                }
                else{
                    e = m - 1;
                }
            }
        }

        return false;
    }
}
