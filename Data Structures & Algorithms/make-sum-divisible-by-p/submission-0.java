
class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int target = (int) (totalSum % p);

        // Already divisible by p
        if (target == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long prefixSum = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int currentRem = (int) (prefixSum % p);

            int neededRem = (currentRem - target + p) % p;

            if (map.containsKey(neededRem)) {
                minLength = Math.min(
                    minLength,
                    i - map.get(neededRem)
                );
            }

            map.put(currentRem, i);
        }

        // Cannot remove the whole array
        return minLength == nums.length ? -1 : minLength;
    }
}