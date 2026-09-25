public class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        // prefix[i] stores count of valid words in range words[0 ... i-1]
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (isVowelString(words[i]) ? 1 : 0);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            // Valid count in range [left, right]
            ans[i] = prefix[right + 1] - prefix[left];
        }

        return ans;
    }

    private boolean isVowelString(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}