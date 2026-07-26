class PrefixTree {
    Trie root;
    public PrefixTree() {
         this.root = new Trie();
    }

    public void insert(String word) {
        Trie temp = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(temp.trie[index] == null){
                temp.trie[index] = new Trie();
            }
            temp = temp.trie[index];
        }
        temp.flag = true;
    }

    public boolean search(String word) {
        Trie temp = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(i == word.length()-1){
                if(temp.trie[index] != null && temp.trie[index].flag){
                    return true;
                }
            }
            if(temp.trie[index] != null){
                temp = temp.trie[index];
            }
            else{
                return false;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
         Trie temp = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i)-'a';
            if(temp.trie[index] == null){
                return false;
            }
            temp = temp.trie[index];
        }
        return true;
    }
}

class Trie {
    Trie[] trie;
    boolean flag;

    public Trie(){
        this.trie = new Trie[26];
        this.flag = false;
    }
}
