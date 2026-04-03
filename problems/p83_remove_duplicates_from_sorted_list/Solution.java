package problems.p83_remove_duplicates_from_sorted_list;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.deleteDuplicates(new ListNode(0)));
  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;

    while (current != null && current.next != null) {
      if (current.val == current.next.val) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }

    return head;
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
