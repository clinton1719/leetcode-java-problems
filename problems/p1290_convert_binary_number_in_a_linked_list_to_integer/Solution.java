package problems.p1290_convert_binary_number_in_a_linked_list_to_integer;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.getDecimalValue(new ListNode(0)));
  }

  public int getDecimalValue(ListNode head) {
    int num = 0;
    while (head != null) {
      num = num * 2 + head.val;
      head = head.next;
    }
    return num;
  }

  public int getDecimalValue2(ListNode head) {
    int num = 0;
    while (head != null) {
      num = (num << 1) | head.val;
      head = head.next;
    }
    return num;
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
