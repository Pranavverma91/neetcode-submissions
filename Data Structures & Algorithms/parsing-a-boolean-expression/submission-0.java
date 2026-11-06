class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == ',' ) {
                continue;
            }

            if (ch != ')') {
                stack.push(ch);
            } else {
                int trueCount = 0;
                int falseCount = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();

                    if (val == 't') {
                        trueCount++;
                    } else if (val == 'f') {
                        falseCount++;
                    }
                }
                stack.pop();

                char operator = stack.pop();

                boolean result;

                if (operator == '!') {
                    result = (falseCount == 1);
                } else if (operator == '&') {
                    result = (falseCount == 0);
                } else {
                    result = (trueCount > 0);
                }

                stack.push(result ? 't' : 'f');
            }
        }

        return stack.pop() == 't';
    }
}