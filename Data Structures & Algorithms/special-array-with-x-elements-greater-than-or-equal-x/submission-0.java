public class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n + 1];
        
        for (int num : nums) {
            counts[Math.min(num, n)]++;
        }
        
        int greaterOrEqualCount = 0;
        
        for (int x = n; x >= 0; x--) {
            greaterOrEqualCount += counts[x];
            if (greaterOrEqualCount == x) {
                return x;
            }
        }
        
        return -1;
    }
}