// Optimal

class Solution {
  public Node removeDuplicates(Node head) {
    if (head == null || head.next == null) return head;
    // Pointer to traverse the LL
    Node temp = head;
    // Pointer to track the distinct node
    Node distinct = head;
    // Traverse the LL
    while (temp != null) {
      // If a distinct data node is found
      if (temp.data != distinct.data) {
        // Link it to our distinct list and update the distinct pointer to this new distinct node
        distinct.next = temp;
        temp.prev = distinct;
        distinct = temp;
      }
      temp = temp.next;
    }
    // In case all nodes are same, this statement ensures that only one node is returned
    distinct.next = null;
    return head;
  }
}

// T.C => O(n)
// S.C => O(1)
