class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] available = new int[26];

        for (char c : chars.toCharArray()) {
            available[c - 'a']++;
        }

        int total = 0;

        for (String word : words) {
            int[] needed = new int[26];
            boolean canForm = true;

            for (char c : word.toCharArray()) {
                needed[c - 'a']++;

                if (needed[c - 'a'] > available[c - 'a']) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                total += word.length();
            }
        }

        return total;
    }
}