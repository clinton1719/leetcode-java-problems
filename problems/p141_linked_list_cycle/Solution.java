package problems.p141_linked_list_cycle;

public class Solution {
  public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (fast == null) {
        return false;
      }
      if (fast == slow) {
        return true;
      }
    }

    return false;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
