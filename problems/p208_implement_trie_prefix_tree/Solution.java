package problems.p208_implement_trie_prefix_tree;

public class Solution {

  static void main() {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");
    trie.search("app");
    trie.startsWith("app");
  }

  static class Trie {
    Node rootNode;

    public Trie() {
      rootNode = new Node();
    }

    public void insert(String word) {
      Node currentNode = rootNode;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        int index = c - 'a';

        if (currentNode.nodes[index] == null) {
          currentNode.nodes[index] = new Node();
        }
        currentNode = currentNode.nodes[index];
      }
      currentNode.setWord(true);
    }

    public boolean search(String word) {
      Node currentNode = rootNode;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        int index = c - 'a';

        if (currentNode.nodes[index] == null) {
          return false;
        }
        currentNode = currentNode.nodes[index];
      }
      return currentNode.isWord();
    }

    public boolean startsWith(String prefix) {
      Node currentNode = rootNode;
      for (int i = 0; i < prefix.length(); i++) {
        char c = prefix.charAt(i);
        int index = c - 'a';

        if (currentNode.nodes[index] == null) {
          return false;
        }
        currentNode = currentNode.nodes[index];
      }
      return true;
    }

    static class Node {
      Node[] nodes = new Node[26];
      boolean isWord = false;

      public Node() {}

      public boolean isWord() {
        return isWord;
      }

      public void setWord(boolean word) {
        isWord = word;
      }
    }
  }
}
