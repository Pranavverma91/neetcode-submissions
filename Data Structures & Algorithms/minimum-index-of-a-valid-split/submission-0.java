class Solution {
    public int minimumIndex(java.util.List<Integer> nums) {
        int n = nums.size();

        // Step 1: Find dominant element using Boyer-Moore
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Count total occurrences of dominant element
        int totalCount = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalCount++;
            }
        }

        // Step 3: Try every possible split
        int leftCount = 0;

        for (int i = 0; i < n - 1; i++) {

            if (nums.get(i) == candidate) {
                leftCount++;
            }

            int leftSize = i + 1;
            int rightSize = n - leftSize;

            int rightCount = totalCount - leftCount;

            // Candidate must be dominant on both sides
            if (leftCount * 2 > leftSize &&
                rightCount * 2 > rightSize) {
                return i;
            }
        }

        return -1;
    }
}