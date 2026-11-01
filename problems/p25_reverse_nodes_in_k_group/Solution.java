package problems.p25_reverse_nodes_in_k_group;

import problems.ListNode;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    ListNode node = ListNode.buildListNode(new int[] {1, 2, 3, 4, 5});
    ListNode.printNodes(solution.reverseKGroup(node, 2));
  }

  /**
   * @param head THe head of the current sub list
   * @return The head of the reversed sub list
   */
  private static ListNode reverseSubList(ListNode head) {
    ListNode dummy = new ListNode();
    ListNode current = head;

    while (current != null) {
      ListNode nextNode = current.next;
      current.next = dummy.next;
      dummy.next = current;
      current = nextNode;
    }

    return dummy.next;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    // Create a dummy node to simplify edge cases
    ListNode dummyNode = new ListNode();
    dummyNode.next = head;

    // Pointer to track the node before the current group
    ListNode previousGroupTail = dummyNode;

    while(previousGroupTail != null) {
      ListNode currentnode = previousGroupTail;

      // check if atleast k nodes are there
      for (int i = 0; i<k; i++) {
        currentnode = currentnode.next;
        if (currentnode == null) {
          // less than k nodes, no need to reverse, just return
          return dummyNode.next;
        }
      }

      // save pointers before reversing
      ListNode groupStart = previousGroupTail.next; // first node of current group
      ListNode nextGroupStart = currentnode.next; // first node of next group

      currentnode.next = null; // disconnect to reverse

      previousGroupTail.next = reverseSubList(groupStart);
      groupStart.next = nextGroupStart;
      previousGroupTail = groupStart;
    }

    return dummyNode.next;
  }
}
