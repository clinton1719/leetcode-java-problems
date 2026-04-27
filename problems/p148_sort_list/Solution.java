package problems.p148_sort_list;

import problems.ListNode;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    ListNode.printNodes(solution.sortList(ListNode.buildListNode(new int[] {4, 2, 1, 3})));
  }

  private static ListNode sort(ListNode left, ListNode right) {
    ListNode head = new ListNode(0);
    ListNode current = head;
    while(left!=null && right!=null) {
      if (left.val < right.val) {
        current.next = left;
        left = left.next;
      } else {
        current.next = right;
        right = right.next;
      }
      current = current.next;
    }

    if (left != null) {
      current.next = left;
    } else {
      current.next = right;
    }

    return head.next;
  }

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode slow = head, prev = head, fast = head;

    while(fast!= null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = null;

    ListNode left = sortList(head);
    ListNode right = sortList(slow);

    return sort(left, right);
  }
}
