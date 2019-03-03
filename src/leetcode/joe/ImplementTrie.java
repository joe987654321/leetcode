package leetcode.joe;

public class ImplementTrie {
    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    public static class Trie {
        private static class TrieNode {
            public boolean isLeaf = false;
            public TrieNode[] next = new TrieNode[26];
        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert (String word){
            if (word != null && word.length() != 0) {
                TrieNode now = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (now.next[c - 'a'] == null) {
                        now.next[c - 'a'] = new TrieNode();
                    }
                    now = now.next[c-'a'];
                }
                now.isLeaf = true;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search (String word){
            if (word == null) return false;
            if (word.length() == 0) return true;
            TrieNode tail = tailOfInput(word);
            if (tail == null) return false;
            return tail.isLeaf;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith (String prefix){
            if (prefix == null) return false;
            if (prefix.length() == 0) return true;
            TrieNode tail = tailOfInput(prefix);
            return tail != null;
        }

        private TrieNode tailOfInput (String s) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (now.next[c-'a'] != null) {
                    now = now.next[c-'a'];
                } else {
                    return null;
                }
            }
            return now;
        }
    }
}
