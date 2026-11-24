/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (visited.contains(node)) {
                stack.pop();
                sb.append(')');          // children are done: close this node
            } else {
                visited.add(node);
                sb.append('(').append(node.val);

                if (node.left == null && node.right != null) {
                    sb.append("()");     // keep the left slot so the right child is unambiguous
                }
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left); // left on top, so it's handled first
            }
        }

        // drop the outer "(" and ")" added around the root
        return sb.substring(1, sb.length() - 1);
    }
}