class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L;
        long high = 10000000000L;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (countLessEqual(nums1, nums2, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long x) {
        long count = 0;

        for (long a : nums1) {
            if (a == 0) {
                if (x >= 0) {
                    count += nums2.length;
                }
            } 
            else if (a > 0) {
                // a * b <= x
                long limit = Math.floorDiv(x, a);
                count += upperBound(nums2, limit);
            } 
            else {
                // a < 0
                // a * b <= x  =>  b >= ceil(x / a)
                long limit = ceilDiv(x, a);
                count += nums2.length - lowerBound(nums2, limit);
            }
        }

        return count;
    }

    // First index where nums[index] >= target
    private int lowerBound(int[] nums, long target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // First index where nums[index] > target
    private int upperBound(int[] nums, long target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // ceil(a / b)
    private long ceilDiv(long a, long b) {
        long q = Math.floorDiv(a, b);
        long r = a - q * b;

        return r == 0 ? q : q + 1;
    }
}