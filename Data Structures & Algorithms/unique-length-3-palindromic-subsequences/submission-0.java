class Solution {
    public int countPalindromicSubsequence(String s) {
        int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);

            if (first != -1 && first < last) {
                boolean[] middle = new boolean[26];

                for (int i = first + 1; i < last; i++) {
                    middle[s.charAt(i) - 'a'] = true;
                }

                for (boolean present : middle) {
                    if (present) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}