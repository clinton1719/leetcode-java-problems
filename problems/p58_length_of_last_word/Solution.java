package problems.p58_length_of_last_word;

public class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;

        for(int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                if (length > 0) {
                    return length;
                }
            }
        }

        return length;
    }

    static void main() {
        String s = "Hello World";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord(s));
    }
}
