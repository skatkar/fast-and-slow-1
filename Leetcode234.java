public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        //1. Find middle node
        ListNode middleNode = findMiddle(head);

        //2. Reverse the second half
        ListNode newHead = reverseList(middleNode.next);
        middleNode.next = null;

        //3. Compare the node individually
        ListNode first = head;
        ListNode second = newHead;

        while(first != null && second != null) {
            if(first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev, current, next;
        prev = null; current = head; next = current.next;

        while(next != null){
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }

        current.next = prev;

        return current;
    }
}
