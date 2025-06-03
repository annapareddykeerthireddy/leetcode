class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases easily (like removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n+1 steps ahead so slow ends up right before the node to remove
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast hits the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the nth node
        slow.next = slow.next.next;

        // Return the real head
        return dummy.next;
    }
}