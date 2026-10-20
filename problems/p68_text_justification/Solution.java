package problems.p68_text_justification;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.fullJustify(
            new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int wordIndex = 0;
    int totalWords = words.length;

    while (wordIndex < totalWords) {
      List<String> currentLineWords = new ArrayList<>();

      currentLineWords.add(words[wordIndex]);
      int currentLineLength = words[wordIndex].length();
      wordIndex++;

      // add words as much as possible
      while (wordIndex < totalWords
          && currentLineLength + 1 + words[wordIndex].length() <= maxWidth) {
        currentLineWords.add(words[wordIndex]);
        currentLineLength += 1 + words[wordIndex].length();
        wordIndex++;
      }

      // handle last line or lines containing one word only
      if (wordIndex == totalWords || currentLineWords.size() == 1) {
        String currentLine = String.join(" ", currentLineWords);
        String rightPadding = " ".repeat(maxWidth - currentLine.length());
        result.add(currentLine + rightPadding);
        continue;
      }

      int totalSpacesRequired = maxWidth - currentLineLength;
      int baseSpaces = totalSpacesRequired / (currentLineWords.size() - 1);
      int additionalSpaces = totalSpacesRequired % (currentLineWords.size() - 1);

      StringBuilder currentString = new StringBuilder();
      for (int i = 0; i < currentLineWords.size() - 1; i++) {
        currentString
            .append(currentLineWords.get(i))
            .append(" ") // one gap required anyways
            .append(" ".repeat(baseSpaces))
            .append(" ".repeat(i < additionalSpaces ? 1 : 0));
      }
      currentString.append(currentLineWords.getLast());

      result.add(currentString.toString());
    }

    return result;
  }
}
