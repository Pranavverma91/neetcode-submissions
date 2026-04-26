class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // track max frequency in current window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // if replacements needed > k → shrink window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
