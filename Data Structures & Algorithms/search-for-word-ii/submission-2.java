class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        PrefixTrie pt = new PrefixTrie();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < words.length; i++){
            pt.insert(words[i],i);
        }

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                findWords(board,row,col,ans,pt.root,words,visited);
            }
        }

        return ans;
    }

    public void findWords(char[][] board, int row, int col, List<String> ans,Trie root,String[] words,boolean[][] visited){
        if(root.flag && root.index != -1){
            ans.add(words[root.getIndex()]);
            root.setIndex(-1);
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[row].length || visited[row][col]){
            return;
        }

        visited[row][col] = true;

        if(root.contains(board[row][col])){
            findWords(board,row + 1,col,ans,root.getTrie(board[row][col]),words,visited);
            findWords(board,row - 1,col,ans,root.getTrie(board[row][col]),words,visited);
            findWords(board,row,col + 1,ans,root.getTrie(board[row][col]),words,visited);
            findWords(board,row,col - 1,ans,root.getTrie(board[row][col]),words,visited);
        }

        visited[row][col] = false;

    }
}

class PrefixTrie {
    Trie root;

    public PrefixTrie(){
        this.root = new Trie();
    }

    public void insert(String word, int index){
        Trie temp = root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!temp.contains(ch)){
                temp.setTrie(ch,new Trie());
            }
            temp = temp.getTrie(ch);
        }
        temp.setFlag(true);
        temp.setIndex(index);
    }

}

class Trie{
    private Trie[] trie;
    private boolean flag;
    private int index;

    public Trie(){
        this.trie = new Trie[26];
        this.flag = false;
        this.index = -1;
    }

    public Trie getTrie(char ch){
        return this.trie[ch - 'a'];
    }

    public void setTrie(char ch, Trie trie){
        this.trie[ch - 'a'] = trie;
    }

    public boolean getFlag(){
        return this.flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    public int getIndex(){
        return this.index;
    }

    public void setIndex(int index){
        this.index = index;
    }

    public boolean contains(char ch){
        return this.trie[ch - 'a'] != null;
    }
}
