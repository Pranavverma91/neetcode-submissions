class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }

        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        int start = 0;
        while (start < stack.length() && stack.charAt(start) == '0') {
            start++;
        }

        String result = stack.substring(start);
        return result.isEmpty() ? "0" : result;
    }
}