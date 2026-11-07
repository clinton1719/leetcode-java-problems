package problems.p211_design_add_and_search_words_data_structure;

public class Solution {

  static void main() {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    wordDictionary.search("pad"); // return False
    wordDictionary.search("bad"); // return True
    wordDictionary.search(".ad"); // return True
    wordDictionary.search("b.."); // return True
  }

  static class WordDictionary {
    private final Node rootNode;

    public WordDictionary() {
      rootNode = new Node();
    }

    public void addWord(String word) {
      Node currentNode = rootNode;

      for (int i = 0; i < word.length(); i++) {
        char character = word.charAt(i);
        int index = character - 'a';

        if (currentNode.nodes[index] == null) {
          currentNode.nodes[index] = new Node();
        }

        currentNode = currentNode.nodes[index];
      }

      currentNode.isEnd = true;
    }

    public boolean search(String word) {
      return isAnyFound(word, rootNode, 0);
    }

    private boolean isAnyFound(String word, Node currentNode, int index) {
      if (index == word.length()) {
        return currentNode.isEnd;
      }

      char character = word.charAt(index);

      if (character == '.') {
        for (Node node : currentNode.nodes) {
          if (node != null && isAnyFound(word, node, index + 1)) {
            return true;
          }
        }

        return false;
      }

      Node nextNode = currentNode.nodes[character - 'a'];

      return nextNode != null && isAnyFound(word, nextNode, index + 1);
    }

    private static class Node {
      Node[] nodes = new Node[26];
      boolean isEnd;
    }
  }
}
