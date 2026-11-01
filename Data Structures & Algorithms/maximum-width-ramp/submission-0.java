class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int best = 0;
        for (int j = n - 1; j >= 0 && !stack.isEmpty(); j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                best = Math.max(best, j - stack.pop());
            }
        }

        return best;
    }
}