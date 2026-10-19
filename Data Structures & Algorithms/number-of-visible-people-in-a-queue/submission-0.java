class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] answer = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {

            while (top >= 0 && stack[top] < heights[i]) {
                answer[i]++;
                top--;
            }

            if (top >= 0) {
                answer[i]++;
            }

            stack[++top] = heights[i];
        }

        return answer;
    }
}
