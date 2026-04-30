class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // Find max pile
        for (int p : piles) {
            right = Math.max(right, p);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                ans = mid;
                right = mid - 1; // try smaller k
            } else {
                left = mid + 1; // increase k
            }
        }

        return ans;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;

        for (int p : piles) {
            hours += (p + k - 1) / k; // ceil(p/k)
        }

        return hours <= h;
    }
}