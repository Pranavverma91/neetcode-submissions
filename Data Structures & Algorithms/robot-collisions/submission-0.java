class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(positions[a], positions[b]));

        Deque<Integer> stack = new ArrayDeque<>(); 

        for (int idx : order) {
            if (directions.charAt(idx) == 'R') {
                stack.push(idx);
                continue;
            }
            while (healths[idx] > 0 && !stack.isEmpty()) {
                int top = stack.peek();

                if (healths[top] < healths[idx]) {
                    healths[top] = 0;
                    stack.pop();
                    healths[idx]--;
                } else if (healths[top] == healths[idx]) {
                    healths[top] = 0;
                    stack.pop();
                    healths[idx] = 0;
                } else {
                    healths[top]--;
                    healths[idx] = 0;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int h : healths) {
            if (h > 0) result.add(h);
        }
        return result;
    }
}