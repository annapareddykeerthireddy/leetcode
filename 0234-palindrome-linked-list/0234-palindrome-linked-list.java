class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }

    public static ListNode deserialize(String data) {
        data = data.replaceAll("\\[|\\]|\\s", "");
        if (data.isEmpty()) return null;
        String[] values = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (String val : values) {
            curr.next = new ListNode(Integer.parseInt(val));
            curr = curr.next;
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfStart = reverseList(slow.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean palindrome = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                palindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        slow.next = reverseList(secondHalfStart);

        return palindrome;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }

    // Optional main method for local testing
    public static void main(String[] args) {
        ListNode head = ListNode.deserialize("[1,2,2,1]");
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(head));  // true

        head = ListNode.deserialize("[1,2]");
        System.out.println(sol.isPalindrome(head));  // false
    }
}