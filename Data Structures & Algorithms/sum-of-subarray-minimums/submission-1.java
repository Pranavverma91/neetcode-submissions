class Solution {
    public int sumSubarrayMins(int[] arr) {
        final long MOD = 1_000_000_007L;
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] >= arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                long count = (long) (mid - left) * (i - mid);
                sum = (sum + arr[mid] * count) % MOD;
            }
            stack.push(i);
        }

        return (int) ((sum % MOD + MOD) % MOD);
    }
}