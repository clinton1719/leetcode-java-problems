package problems.p141_linked_list_cycle;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.hasCycle(new ListNode(1)));
  }

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
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}
