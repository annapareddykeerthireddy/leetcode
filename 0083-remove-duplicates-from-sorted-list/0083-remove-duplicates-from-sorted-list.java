class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }

    public static ListNode deserialize(String data) {
        data = data.replaceAll("\\[|\\]|\\s", "");
        if (data.isEmpty()) return null;

        String[] values = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String val : values) {
            current.next = new ListNode(Integer.parseInt(val));
            current = current.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // Optional main to test locally (remove before submitting if platform doesn't allow)
    public static void main(String[] args) {
        ListNode head = ListNode.deserialize("[1,1,2,3,3]");
        Solution sol = new Solution();
        ListNode result = sol.deleteDuplicates(head);
        ListNode.printList(result); // Expected: 1->2->3
    }
}