class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        // Step 1: Add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Find sequences
        for (int num : set) {
            // Start only if it's the beginning of sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}