// Recursive

/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int addOneToLL(Node temp) {
        // Return carry of 1 to add to last node
        if (temp == null) 
            return 1;
        
        // Recursively call addOneToLL for the next node 
        int carry = addOneToLL(temp.next); 
        
        /* Add the carry 
        to the current node's dataue */
        temp.data += carry; 
        
        /* If the current node's dataue 
        is less than 10, carry is 0 */
        if (temp.data < 10) 
            return 0;
        
        /* If the current node's dataue is 10 or more
        set it to 0 and return a carry of 1 */
        temp.data = 0; 
        return 1;
    }
    public Node addOne(Node head) {
        /* Call the helper function 
        to start the addition process */
        int carry = addOneToLL(head);
        
        /* If there is a carry left 
        after processing all nodes
        add a new node at the head */
        if (carry == 1) { 
            Node newNode = new Node(1);
            // Link the newNode to head
            newNode.next = head; 
            // Update the head to the new node 
            head = newNode; 
        }
        // Return the head 
        return head;
    }
}

// T.C => O(n)
// S.C => O(n)
