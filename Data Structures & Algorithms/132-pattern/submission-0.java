class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int two = Integer.MIN_VALUE; 

        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];

            if (x < two) {
                return true; 
            }

            while (!stack.isEmpty() && stack.peek() < x) {
                two = stack.pop(); 
            }

            stack.push(x);
        }

        return false;
    }
}