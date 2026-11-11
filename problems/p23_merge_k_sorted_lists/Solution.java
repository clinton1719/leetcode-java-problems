package problems.p23_merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;
import problems.ListNode;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.mergeKLists(
            new ListNode[] {
              ListNode.buildListNode(new int[] {1, 4, 5}),
              ListNode.buildListNode(new int[] {1, 3, 4}),
              ListNode.buildListNode(new int[] {2, 6})
            }));
  }

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap =
        new PriorityQueue<>(Comparator.comparing(listNode -> listNode.val));
    ListNode dummyHead = new ListNode();

    for (ListNode listNode : lists) {
      if (listNode != null) {
        minHeap.offer(listNode);
      }
    }

    ListNode currentNode = dummyHead;

    while (!minHeap.isEmpty()) {
      ListNode head = minHeap.poll();
      if (head.next != null) {
        minHeap.offer(head.next);
      }
      head.next = null;
      currentNode.next = head;
      currentNode = head;
    }

    return dummyHead.next;
  }
}
