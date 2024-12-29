class TrieNode:
    def __init__(self):
        self.children=[None]*26
        self.is_end_of_word=False

    def contains_key(self,ch):
        return self.children[ord(ch)-ord('a')] is not None
    
    def get(self,ch):
        return self.children[ord(ch)-ord('a')]
    
    def put(self,ch,node):
        self.children[ord(ch)-ord('a')]=node

    def set_end(self):
        self.is_end_of_word=True
    
    def is_end(self):
        return self.is_end_of_word
    
class Trie:
    def __init__(self):
        self.root=TrieNode()

    def insert(self,word):
        temp=self.root
        for ch in word:
            if not temp.contains_key(ch): # type: ignore
                temp.put(ch,TrieNode()) # type: ignore
            temp=temp.get(ch) # type: ignore
        temp.set_end() # type: ignore

    def search(self,word):
        temp=self.root
        for ch in word:
            if not temp.contains_key(ch): # type: ignore
                return False
            temp=temp.get(ch) # type: ignore
        return temp.is_end() # type: ignore
    
    def starts_with(self,prefix):
        temp=self.root
        for ch in prefix:
            if not temp.contains_key(ch): # type: ignore
                return False
            temp=temp.get(ch) # type: ignore
        return True
    
trie=Trie()
trie.insert("apple")
print(trie.search("apple"))  # True
print(trie.search("app"))  # False
print(trie.starts_with("app"))  # True
trie.insert("app")
print(trie.search("app"))  # True