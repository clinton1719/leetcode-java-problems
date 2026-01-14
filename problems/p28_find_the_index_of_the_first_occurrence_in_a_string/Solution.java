package problems.p28_find_the_index_of_the_first_occurrence_in_a_string;

public class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        if (haystackLength == 0) return 0;
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

    //kmp algorithm using LPS
    public int strStr2(String haystack, String needle) {
        if (haystack.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        int[] lps = findLongestPrefixSuffix(needle);

        int i = 0, j = 0;
        while (i < haystack.length()) {
           if (haystack.charAt(i) == needle.charAt(j)) {
               i++;
               j++;
           }  else {
               if (j == 0) {
                   i++;
               } else {
                   j = lps[j-1];
               }
           }
           if (j == needle.length()) return i - needle.length();
        }

        return -1;
    }

    private static int[] findLongestPrefixSuffix(String needle) {
        int[] lps = new int[needle.length()];
        lps[0] = 0;
        int j = 0, i = 1;
        while(i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                if (j == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }

        return lps;
    }

    // Rabin Karp rolling hash solution
    public int strStr3(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;
        if (m > n) return -1;

        // Constants for hashing
        long base = 31;
        long modulus = (long) 1e9 + 7; // Large prime

        long needleHash = 0;
        long windowHash = 0;
        long maxWeight = 1; // base^(m-1) % modulus

        // 1. Precompute needleHash and the first windowHash
        for (int i = 0; i < m; i++) {
            needleHash = (needleHash * base + needle.charAt(i)) % modulus;
            windowHash = (windowHash * base + haystack.charAt(i)) % modulus;
            if (i < m - 1) {
                maxWeight = (maxWeight * base) % modulus;
            }
        }

        // 2. Slide the window across haystack
        for (int i = 0; i <= n - m; i++) {
            // If hashes match, verify characters to handle collisions
            if (windowHash == needleHash) {
                if (haystack.substring(i, i + m).equals(needle)) {
                    return i;
                }
            }

            // 3. Update rolling hash for next window
            if (i < n - m) {
                // Remove leading char, add trailing char
                windowHash = (windowHash - (haystack.charAt(i) * maxWeight) % modulus + modulus) % modulus;
                windowHash = (windowHash * base + haystack.charAt(i + m)) % modulus;
            }
        }

        return -1;
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.strStr2("cleetcode", "leet"));
    }
}
