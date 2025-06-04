class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }

    // Helper method to create a linked list from string like "[1,2,3]"
    public static ListNode deserialize(String data) {
        data = data.replaceAll("\\[|\\]|\\s", "");
        if (data.isEmpty()) return null;
        String[] vals = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (String val : vals) {
            curr.next = new ListNode(Integer.parseInt(val));
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to print the linked list
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) break;

            ListNode groupNext = kth.next;
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // Main method for testing
    public static void main(String[] args) {
        ListNode head = ListNode.deserialize("[1,2,3,4,5]");
        Solution sol = new Solution();
        ListNode result = sol.reverseKGroup(head, 2);
    }
}