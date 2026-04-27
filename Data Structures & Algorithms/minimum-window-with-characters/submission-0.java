
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        
        // Step 1: Count characters in t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int required = map.size();  // unique chars needed
        int formed = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Check if current char satisfies requirement
            if (map.containsKey(c) && windowMap.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            // Try shrinking window
            while (left <= right && formed == required) {
                char ch = s.charAt(left);

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove from window
                windowMap.put(ch, windowMap.get(ch) - 1);
                if (map.containsKey(ch) && windowMap.get(ch) < map.get(ch)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}