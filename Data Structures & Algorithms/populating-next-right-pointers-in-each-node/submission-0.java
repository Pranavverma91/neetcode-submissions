/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/
class Solution {
    public Node connect(Node root) {
        Node leftmost = root;

        while (leftmost != null && leftmost.left != null) {
            Node curr = leftmost;

            while (curr != null) {
                curr.left.next = curr.right;          // same parent

                if (curr.next != null) {
                    curr.right.next = curr.next.left; // across parents
                }

                curr = curr.next;                     // move along this level
            }

            leftmost = leftmost.left;                 // go down a level
        }

        return root;
    }
}