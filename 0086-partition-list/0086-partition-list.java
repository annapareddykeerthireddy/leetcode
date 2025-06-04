class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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
    public ListNode partition(ListNode head, int x) {
        ListNode beforeDummy = new ListNode(0);
        ListNode afterDummy = new ListNode(0);

        ListNode before = beforeDummy;
        ListNode after = afterDummy;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;            // Important to avoid cycle
        before.next = afterDummy.next;

        return beforeDummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode head1 = ListNode.deserialize("[1,4,3,2,5,2]");
        System.out.println(sol.partition(head1, 3)); // Output: [1,2,2,4,3,5]

        ListNode head2 = ListNode.deserialize("[2,1]");
        System.out.println(sol.partition(head2, 2)); // Output: [1,2]
    }
}