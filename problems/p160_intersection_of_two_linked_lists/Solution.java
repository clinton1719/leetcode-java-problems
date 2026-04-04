package problems.p160_intersection_of_two_linked_lists;

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode p1 = headA, p2 = headB;

    while (p1 != p2) {
      p1 = (p1 == null) ? headB : p1.next;
      p2 = (p2 == null) ? headA : p2.next;
    }

    return p1;
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
