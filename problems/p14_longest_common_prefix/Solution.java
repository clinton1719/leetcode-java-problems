package problems.p14_longest_common_prefix;

import java.util.Arrays;

public class Solution {
    static void main() {
        String[] strs = {"flower", "flow", "flight"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
        System.out.println(solution.longestCommonPrefix2(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;

        while (i < first.length() && i < last.length()) {
            if (first.charAt(i) == last.charAt(i)) {
                i++;
            } else {
                break;
            }
        }

        return first.substring(0, i);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
