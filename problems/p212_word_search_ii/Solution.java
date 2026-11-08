package problems.p212_word_search_ii;

import java.util.*;

public class Solution {
  char[][] board;
  String[] words;
  List<String> result;

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.findWords(
            new char[][] {
              new char[] {'o', 'a', 'a', 'n'},
              new char[] {'e', 't', 'a', 'e'},
              new char[] {'i', 'h', 'k', 'r'},
              new char[] {'i', 'f', 'l', 'v'}
            },
            new String[] {"oath", "pea", "eat", "rain"}));
  }

  private void dfs(Trie currentNode, int row, int col) {
    int currentCharacter = this.board[row][col] - 'a';

    if (currentNode.children[currentCharacter] == null) {
      return;
    }

    currentNode = currentNode.children[currentCharacter];

    if (currentNode.wordIndex != -1) {
      result.add(words[currentNode.wordIndex]);
      currentNode.wordIndex = -1;
    }

    char originalChar = board[row][col];
    board[row][col] = '#';

    int[] directions = new int[] {-1, 0, 1, 0, -1};

    for (int k = 0; k < 4; k++) {
      int newRow = row + directions[k];
      int newCol = col + directions[k + 1];

      if (newRow >= 0
          && newRow < board.length
          && newCol >= 0
          && newCol < board[0].length
          && board[newRow][newCol] != '#') {
        dfs(currentNode, newRow, newCol);
      }
    }

    board[row][col] = originalChar;
  }

  public List<String> findWords(char[][] board, String[] words) {
    this.board = board;
    this.words = words;
    result = new ArrayList<>();

    Trie rootTrie = new Trie();
    for (int i = 0; i < words.length; i++) {
      rootTrie.insert(words[i], i);
    }

    int rows = board.length;
    int cols = board[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        dfs(rootTrie, i, j);
      }
    }

    return result;
  }

  static class Trie {
    Trie[] children = new Trie[26];
    int wordIndex = -1;

    public void insert(String word, int index) {
      Trie currentNode = this;

      for (int i = 0; i < word.length(); i++) {
        int character = word.charAt(i) - 'a';

        if (currentNode.children[character] == null) {
          currentNode.children[character] = new Trie();
        }

        currentNode = currentNode.children[character];
      }

      currentNode.wordIndex = index;
    }
  }
}
