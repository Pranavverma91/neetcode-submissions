class Solution {
    public String removeStars(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.deleteCharAt(stack.length() - 1); // remove closest letter to the left
            } else {
                stack.append(c);
            }
        }

        return stack.toString();
    }
}