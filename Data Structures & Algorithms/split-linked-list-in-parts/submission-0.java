/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int partSize = length / k;
        int remainder = length % k;

        curr = head;

        for (int i = 0; i < k; i++) {
            result[i] = curr;

            int currentSize = partSize + (i < remainder ? 1 : 0);

            for (int j = 1; j < currentSize; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }

            if (curr != null) {
                ListNode nextPart = curr.next;
                curr.next = null;
                curr = nextPart;
            }
        }

        return result;
    }
}