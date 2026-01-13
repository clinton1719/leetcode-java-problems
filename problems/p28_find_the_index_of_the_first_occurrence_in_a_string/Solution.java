package problems.p28_find_the_index_of_the_first_occurrence_in_a_string;

public class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        if (needleLength > haystackLength) return -1;
        for (int i = 0; i < haystackLength; i++) {
            if (i+needleLength > haystackLength) return -1;
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.startsWith(needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    //kmp algorithm
//    public int strStr2(String haystack, String needle) {
//
//    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.strStr("leetcode", "leeto"));
    }
}
