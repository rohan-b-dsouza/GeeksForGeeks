// Optimal

/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        // Edge case: if the list is empty or has only one element, return as it is
       if (head == null || head.next == null) return head;
         // Create dummy heads for three separate lists: 0s, 1s, and 2s
        Node dummyzero = new Node(-1);
        Node dummyone = new Node(-1);
        Node dummytwo = new Node(-1);
          // Create pointers to build the three lists
        Node zero = dummyzero;
        Node one = dummyone;
        Node two = dummytwo;
        Node temp = head;
          // Traverse the original list and attach nodes to corresponding dummynode list
        while (temp != null) {
            // if node value is zero, connect it to the dummyzero list
            if (temp.data == 0) {
                zero.next = temp; // attach to 0s list
                zero = zero.next;
            }
                // if node value is one, connect it to the dummyone list
            else if (temp.data == 1) {
                one.next = temp; // attach to 1s list
                one = one.next;
            }
                // if node value is two, connect it to the dummytwo list
            else {
                two.next = temp; // attach to 2s list
                two = two.next;
            }
            temp = temp.next;
        }
        
        // Combine the three lists:
        // - 0s list connects to 1s list if it's non-empty, else to 2s list
        // - 1s list connects to 2s list
        zero.next = dummyone.next == null ? dummytwo.next : dummyone.next;
        one.next = dummytwo.next;
            // Mark the end of final list
        two.next = null;
        // Return the head of the merged list (skipping dummy node)
        return dummyzero.next;
    }
}

// Important Note: We haven't created new lists/nodes; we've only rearranged pointers using dummy nodes

// T.C => O(n)
// S.C => O(1)
