// Optimal

// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // If list is empty return null
    if (head == null) return head;
    Node temp = head;
    while (temp != null) {
        // If current node equals the x data
      if (temp.data == x) {
        // If its a head node
        if (temp == head) {
          head = head.next;
        }
        // get the next node to node to be deleted
        Node nextNode = temp.next;
        // get the prev node to node to be deleted
        Node prevNode = temp.prev;
        // if nextNode exists then link it to the node before the node to be deleted
        if (nextNode != null) {
          nextNode.prev = temp.prev;
        }
        // if prevNode exists then link it to the node after the node to be deleted
        if (prevNode != null) {
          prevNode.next = temp.next;
        }
      }
      // Increment temp pointer to the next node in the LL
      temp = temp.next;
    }
    // Return the head of the LL
    return head;
        
    }
}

// T.C => O(n)
// S.C => O(1)
