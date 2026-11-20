class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int parentVal = d[0], childVal = d[1];
            boolean isLeft = d[2] == 1;

            TreeNode parent = nodes.computeIfAbsent(parentVal, TreeNode::new);
            TreeNode child = nodes.computeIfAbsent(childVal, TreeNode::new);

            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }

        for (int[] d : descriptions) {
            if (!children.contains(d[0])) {
                return nodes.get(d[0]);
            }
        }

        return null; 
    }
}