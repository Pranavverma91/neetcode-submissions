class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();

        stack.push(new HashMap<>());

        int i = 0;
        int n = formula.length();

        while (i < n) {
            char ch = formula.charAt(i);

            if (ch == '(') {
                stack.push(new HashMap<>());
                i++;
            }

            else if (ch == ')') {
                Map<String, Integer> group = stack.pop();
                i++;

                int multiplier = 0;

                while (i < n && Character.isDigit(formula.charAt(i))) {
                    multiplier = multiplier * 10
                               + (formula.charAt(i) - '0');
                    i++;
                }

                if (multiplier == 0) {
                    multiplier = 1;
                }

                Map<String, Integer> parent = stack.peek();

                for (String element : group.keySet()) {
                    parent.put(
                        element,
                        parent.getOrDefault(element, 0)
                        + group.get(element) * multiplier
                    );
                }
            }

            else {
                int start = i;
                i++;

                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }

                String element = formula.substring(start, i);

                int count = 0;

                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count = count * 10
                          + (formula.charAt(i) - '0');
                    i++;
                }

                if (count == 0) {
                    count = 1;
                }

                Map<String, Integer> current = stack.peek();

                current.put(
                    element,
                    current.getOrDefault(element, 0) + count
                );
            }
        }

        Map<String, Integer> result = stack.pop();

        List<String> elements = new ArrayList<>(result.keySet());
        Collections.sort(elements);

        StringBuilder answer = new StringBuilder();

        for (String element : elements) {
            answer.append(element);

            int count = result.get(element);

            if (count > 1) {
                answer.append(count);
            }
        }

        return answer.toString();
    }
}