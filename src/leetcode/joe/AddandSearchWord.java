package leetcode.joe;

public class AddandSearchWord {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
    }

    public static class WordDictionary {

        private static class DictNode {
            boolean isLeaf;
            DictNode [] next = new DictNode[26];
        }

        private DictNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new DictNode();
            root.isLeaf = true;
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word == null || word.length() == 0) return;
            DictNode now = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (now.next[c-'a'] == null) {
                    now.next[c-'a'] = new DictNode();
                }
                now = now.next[c-'a'];
            }
            now.isLeaf = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return _search(root, word);
        }

        public boolean _search(DictNode now, String word) {
            if (word == null) return false;
            if (word.length() == 0) return now.isLeaf;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c != '.') {
                    if (now.next[c-'a'] == null) {
                        return false;
                    }
                    now = now.next[c-'a'];
                } else {
                    for (int j = 0; j < 26; j++) {
                        if (now.next[j] != null && _search(now.next[j], word.substring(i+1))) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return now.isLeaf;
        }
    }
}
