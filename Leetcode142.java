public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        boolean hasCycle = false;
        // With this condition, two things can happen
        // Either there is no cycle or fast reached the end
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Once slow and fast meet, break the loop
            // We will slow down the fast pointer from here onwards
            if(slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle) return null;

        // reset the slow pointer to the head
        slow = head;

        // slow and fast will now proceed with the equals speed
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
