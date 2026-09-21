class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {

        int[] first = new int[26];

        for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }

        int maxLength = -1;

        for (int i = 0; i < s.length(); i++) {

            int index = s.charAt(i) - 'a';
            if (first[index] == -1) {
                first[index] = i;
            } else {
                int length = i - first[index] - 1;

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}