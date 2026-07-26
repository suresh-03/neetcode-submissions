class WordDictionary {
    Trie root;
    public WordDictionary() {
        this.root = new Trie();
    }

    public void addWord(String word) {
        Trie temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.contains(ch)) {
                temp.setTrie(ch);
            }
            temp = temp.getTrie(ch);
        }
        temp.setFlag(true);
    }

    public boolean search(String word) {
        Trie temp = root;
        return search(temp, word, 0);
    }

    public boolean search(Trie temp, String word, int index) {
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (temp.contains((char) (j + 97))) {
                      
                        if (search(temp.getTrie((char) (j + 97)), word, i + 1)) {
                            return true;
                        } 
                    }
                }
                return false;
            } else if (!temp.contains(ch)) {
                return false;
            }
            if (ch != '.') {
                temp = temp.getTrie(ch);
            }
        }
        return temp.getFlag();
    }
}

class Trie {
    private Trie[] trie;
    private boolean flag;

    public Trie() {
        this.trie = new Trie[26];
        this.flag = false;
    }

    public boolean contains(char ch) {
        return this.trie[ch - 'a'] != null;
    }

    public void setTrie(char ch) {
        this.trie[ch - 'a'] = new Trie();
    }

    public Trie getTrie(char ch) {
        return this.trie[ch - 'a'];
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return this.flag;
    }
}
