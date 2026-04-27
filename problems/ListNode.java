package problems;

public class ListNode {
  public int val;
  public ListNode next;

  ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode buildListNode(int[] arr) {
    ListNode head = new ListNode(arr[0]);
    ListNode current = head;
    for (int i = 1; i < arr.length; i++) {
      current.next = new ListNode(arr[i]);
      current = current.next;
    }
    return head;
  }

  public static void printNodes(ListNode head) {
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
