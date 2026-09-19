class Solution {
    public int minOperations(String s) {
        int changes01 = 0; // Make string: 010101...
        int changes10 = 0; // Make string: 101010...

        for (int i = 0; i < s.length(); i++) {
            char expected01 = (i % 2 == 0) ? '0' : '1';
            char expected10 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected01) {
                changes01++;
            }

            if (s.charAt(i) != expected10) {
                changes10++;
            }
        }

        return Math.min(changes01, changes10);
    }
}