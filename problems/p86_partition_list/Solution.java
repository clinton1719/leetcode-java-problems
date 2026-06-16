package problems.p86_partition_list;

import problems.ListNode;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    solution.partition(ListNode.buildListNode(new int[] {1, 4, 3, 2, 5, 2}), 3);
  }

  public ListNode partition(ListNode head, int x) {
    ListNode lessHead = new ListNode(-1);
    ListNode greaterHead = new ListNode(-1);

    ListNode less = lessHead;
    ListNode greater = greaterHead;

    while (head != null) {
      if (head.val >= x) {
        greater.next = new ListNode(head.val);
        greater = greater.next;
      } else {
        less.next = new ListNode(head.val);
        less = less.next;
      }
      head = head.next;
    }

    less.next = greaterHead.next;

    return lessHead.next;
  }
}
