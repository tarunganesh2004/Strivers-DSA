class TrieNode {
    public TrieNode[] children;
    public boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }

    boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    void setWord() {
        isWord = true;
    }
    TrieNode getWord(char ch) {
        return children[ch - 'a'];
    }
}

