class Solution {
    public int arrangeCoins(int n) {

        long left = 0;
        long right = n;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            long coins = mid * (mid + 1) / 2;

            if (coins == n) {
                return (int) mid;
            }

            if (coins < n) {
                // We can build more rows
                left = mid + 1;
            } else {
                // Too many coins required
                right = mid - 1;
            }
        }

        return (int) right;
    }
}