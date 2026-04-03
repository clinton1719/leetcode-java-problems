package problems.p61_rotate_list;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    ListNode one = new ListNode(0);
    ListNode two = new ListNode(1);
    ListNode three = new ListNode(2);
    one.next = two;
    two.next = three;
    System.out.println(solution.rotateRight(one, 4));
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) return head;

    int length = 1;
    ListNode tail = head;

    while (tail.next != null) {
      tail = tail.next;
      length++;
    }

    k = k % length;
    if (k == 0) return head;

    // make circular
    tail.next = head;

    int stepsToNewTail = length - k;
    ListNode newTail = head;

    for (int i = 1; i < stepsToNewTail; i++) {
      newTail = newTail.next;
    }

    ListNode newHead = newTail.next;
    newTail.next = null;

    return newHead;
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
