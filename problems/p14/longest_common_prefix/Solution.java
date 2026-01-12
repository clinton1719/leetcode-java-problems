package problems.p14.longest_common_prefix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
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

    static void main() {
        String[] strs = {"flower","flow","flight"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
