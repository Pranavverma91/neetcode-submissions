class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        freq.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            int remainder = prefixSum % k;

            // Handle negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            count += freq.getOrDefault(remainder, 0);

            freq.put(remainder, freq.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}