public class Lc00211AddAndSearchWordTrieOn {

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        System.out.println(dictionary.search("pad"));
        System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("b.."));
    }
  
    public static class WordDictionary {
        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word == null) {
                return;
            }
            TrieNode node = root;
            int depth = 0;
            while (depth < word.length()) {
                int index = word.charAt(depth) - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
                depth++;
            }
            node.isWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(word, root, 0);
        }

        private boolean search(String word, TrieNode node, int depth) {
            if (node == null) {
                return false;
            }
            if (depth == word.length()) {
                return node.isWord;
            }
            char c = word.charAt(depth);
            if (c == '.') {
                for (TrieNode nextNode : node.next) {
                    if (search(word, nextNode, depth + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                return search(word, node.next[c - 'a'], depth + 1);
            }
        }

        private class TrieNode {
            TrieNode[] next;
            int radix = 26;
            boolean isWord;

            public TrieNode() {
                next = new TrieNode[radix];
            }
        }
    }
}
