package problems.p127_word_ladder;

import java.util.*;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.ladderLength(
            "hit", "cog", new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"))));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return 0;

    int transformationSteps = 1;
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    while (!queue.isEmpty()) {
      transformationSteps++;
      int currentLevelSize = queue.size();

      for (int i = 0; i < currentLevelSize; i++) {
        String word = queue.poll();
        char[] charArray = word.toCharArray();

        for (int charIndex = 0; charIndex < charArray.length; charIndex++) {
          char originalCharacter = charArray[charIndex];

          for (char currentCharacter = 'a'; currentCharacter <= 'z'; currentCharacter++) {
            charArray[charIndex] = currentCharacter;

            String transformedWord = new String(charArray);

            if (!wordSet.contains(transformedWord)) {
              continue;
            }

            if (endWord.equals(transformedWord)) {
              return transformationSteps;
            }

            queue.offer(transformedWord);

            wordSet.remove(transformedWord);
          }

          charArray[charIndex] = originalCharacter;
        }
      }
    }

    return 0;
  }
}
