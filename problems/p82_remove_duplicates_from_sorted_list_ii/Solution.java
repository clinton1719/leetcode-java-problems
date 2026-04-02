package problems.p82_remove_duplicates_from_sorted_list_ii;

public class Solution {
  static void main() {
    int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
    Solution solution = new Solution();
    System.out.println(solution.deleteDuplicates(new ListNode(0)));
  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode start = new ListNode(0);
    ListNode left = start;
    ListNode right = head;

    while (right != null) {
      int count = 0;
      int currentValue = right.val;

      while (right.next != null && right.next.val == currentValue) {
        right = right.next;
        count++;
      }

      if (count > 0) {
        ListNode temp = right;
        right = right.next;
        temp.next = null;
      } else {
        left.next = right;
        left = right;
        right = right.next;
      }
    }
    left.next = null;

    return start.next;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
