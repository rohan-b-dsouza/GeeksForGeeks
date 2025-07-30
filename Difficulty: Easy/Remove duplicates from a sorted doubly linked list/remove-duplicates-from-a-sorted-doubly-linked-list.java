

class Solution {
  public Node removeDuplicates(Node head) {
    if (head == null || head.next == null) return head;
    Node temp = head;
    Node distinct = head;
    while (temp != null) {
      if (temp.data != distinct.data) {
        distinct.next = temp;
        temp.prev = distinct;
        distinct = temp;
      }
      temp = temp.next;
    }
    distinct.next = null;
    return head;
  }
}
