package problems.p21_merge_two_sorted_lists;

public class Solution {

  static void main() {
    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(2);
    list1.next.next = new ListNode(4);

    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(3);
    list2.next.next = new ListNode(4);

    Solution solution = new Solution();
    System.out.println();
    solution.mergeTwoLists(list1, list2);
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        prev.next = list1;
        list1 = list1.next;
      } else {
        prev.next = list2;
        list2 = list2.next;
      }
      prev = prev.next;
    }

    prev.next = (list1 != null) ? list1 : list2;

    return dummy.next;
  }

  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
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
