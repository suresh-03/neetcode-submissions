class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Character>> rowMap = new HashMap<>();
        HashMap<Integer,HashSet<Character>> colMap = new HashMap<>();
        HashMap<String,HashSet<Character>> squareMap = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                String squareKey = ""+(i/3)+""+(j/3);
                if(rowMap.containsKey(i)){
                    if(rowMap.get(i).contains(board[i][j])){
                        return false;
                    }
                }
                else{
                    rowMap.put(i, new HashSet<>());
                }
                if(colMap.containsKey(j)){
                    if(colMap.get(j).contains(board[i][j])){
                        return false;
                    }
                }
                else{
                    colMap.put(j, new HashSet<>());
                }
                 if(squareMap.containsKey(squareKey)){
                    if(squareMap.get(squareKey).contains(board[i][j])){
                        return false;
                    }
                }
                else{
                    squareMap.put(squareKey, new HashSet<>());
                }

                rowMap.get(i).add(board[i][j]);
                colMap.get(j).add(board[i][j]);
                squareMap.get(squareKey).add(board[i][j]);

            }
        }

        return true;

    }
}


