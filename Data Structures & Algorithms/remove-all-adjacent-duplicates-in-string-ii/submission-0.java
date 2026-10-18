class Solution {
    public String removeDuplicates(String s, int k) {
        char[] chars = new char[s.length()];
        int[] count = new int[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            top++;
            chars[top] = ch;

            if (top > 0 && chars[top - 1] == ch) {
                count[top] = count[top - 1] + 1;
            } else {
                count[top] = 1;
            }

            if (count[top] == k) {
                top -= k;
            }
        }

        return new String(chars, 0, top + 1);
    }
}
