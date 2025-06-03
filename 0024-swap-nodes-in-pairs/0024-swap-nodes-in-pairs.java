public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Dummy node to simplify head operations
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null && head.next != null) {
            // Identify nodes to swap
            ListNode first = head;
            ListNode second = head.next;

            // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Re-position pointers for next swap
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
