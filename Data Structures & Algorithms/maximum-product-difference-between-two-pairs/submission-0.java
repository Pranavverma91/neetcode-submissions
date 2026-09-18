class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int largestProduct = nums[n - 1] * nums[n - 2];
        int smallestProduct = nums[0] * nums[1];

        return largestProduct - smallestProduct;
    }
}