import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

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
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        sb.append("[");
        while (current != null) {
            sb.append(current.val);
            current = current.next;
            if (current != null) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        current.next = head;

        k = k % length;
        int stepsToNewHead = length - k;

        ListNode newTail = current;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}