package problems.p203_remove_linked_list_elements;


public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.removeElements(new ListNode(0), 4));
  }

  public ListNode removeElements(ListNode head, int val) {
    ListNode start = new ListNode(0);
    ListNode current = start;

    while (head != null) {
      if (head.val != val) {
        current.next = head;
        current = head;
      }
      head = head.next;
    }
    current.next = null;

    return start.next;
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
