class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        // Edge case
        if (n == 1)
            return nums[0];

        // Case 1: Exclude last house
        int case1 = robLinear(nums, 0, n - 2);

        // Case 2: Exclude first house
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    // Normal House Robber for linear houses
    private int robLinear(int[] nums, int start, int end) {

        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {

            int take = prev2 + nums[i];
            int skip = prev1;

            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}