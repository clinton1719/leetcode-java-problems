package problems.p92_reverse_linked_list_ii;

public class Solution {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head.next == null || left == right) return head;

    ListNode leftHead = null;
    ListNode currentNode = head;
    while (left > 1) {
      leftHead = currentNode;
      currentNode = currentNode.next;
      left--;
      right--;
    }

    ListNode tail = currentNode;
    ListNode prev = null;
    while (right > 2) {
      ListNode next = currentNode.next;
      currentNode.next = prev;
      prev = currentNode;
      currentNode = next;
      right--;
    }

    tail.next = currentNode.next;
    currentNode.next = prev;
    if (leftHead != null) {
      leftHead.next = currentNode;
    }

    return head;
  }

  public class ListNode {
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
