class trieNode {
    trieNode[] children;
    boolean isEndOfWord;

    trieNode() {
        children = new trieNode[26];
        isEndOfWord = false;
    }

    // checks if a node corresponding to a character exists in children
    boolean containsKey(char ch) {
        return children[ch - 'a'] != null; // this will return true if the character is present in the trie
    }

    // adds a new trienode for a character in children
    void put(char ch, trieNode node) {
        children[ch - 'a'] = node;
    }

    // retrieves the trienode for a character
    trieNode get(char ch) { // this will return the node of the character
        return children[ch - 'a'];
    }

    // marks the current node as the end of the word
    void setEnd() {
        isEndOfWord = true;
    }
    
    // checks if the current node is marked as the end of a word
    boolean isEnd() {
        return isEndOfWord;
    }
}

class trieCreation {
    trieNode root; // root of the trie

    trieCreation() {
        root = new trieNode();
    }

    // Insert O(n) where n is the length of the word
    void insert(String word) {
        trieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.containsKey(word.charAt(i))) { // if character is not present, create a new node
                temp.put(word.charAt(i), new trieNode());
            }
            temp = temp.get(word.charAt(i)); // this will move to new reference trie

        }

        temp.setEnd(); // this will mark the end of the word

    }

    // Search O(n) where n is the length of the word
    public boolean search(String word) {
        trieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.containsKey(word.charAt(i))) { // doesnot contain the character
                return false;
            }
            temp = temp.get(word.charAt(i));
        }
        return temp.isEnd(); // if the end of the word is marked then return true
    }
    
    // startswith O(n) where n is the length of the word
    public boolean startswith(String prefix) {
        trieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!temp.containsKey(prefix.charAt(i))) {
                return false;
            }
            temp = temp.get(prefix.charAt(i));
        }
        return true;
    }

}

public class trieImplementation {
    public static void main(String[] args) {
        trieCreation trie= new trieCreation();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app")); // false
        System.out.println(trie.startswith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app")); // true
    }
}