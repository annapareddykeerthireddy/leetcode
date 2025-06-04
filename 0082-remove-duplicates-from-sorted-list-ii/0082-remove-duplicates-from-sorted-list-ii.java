class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Helper method to deserialize string to ListNode
    public static ListNode deserialize(String data) {
        if (data.equals("[]")) return null;
        data = data.replaceAll("\\[|\\]|\\s", "");
        String[] parts = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part));
            current = current.next;
        }
        return dummy.next;
    }

    // Helper to print the list as a string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) sb.append(",");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next; // skip all duplicates
            } else {
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode head1 = ListNode.deserialize("[1,2,3,3,4,4,5]");
        System.out.println(sol.deleteDuplicates(head1)); // Output: [1,2,5]

        ListNode head2 = ListNode.deserialize("[1,1,1,2,3]");
        System.out.println(sol.deleteDuplicates(head2)); // Output: [2,3]
    }
}