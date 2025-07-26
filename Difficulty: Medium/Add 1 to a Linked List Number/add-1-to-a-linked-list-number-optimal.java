// Optimal (Iterative)

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
    // Function to reverse the LL
    public Node reverseList(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null;
        Node next = null;
        Node temp = head;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    public Node addOne(Node head) {
        // If LL is empty, return null
        if (head == null) return head;
        // Reverse the LL
        head =  reverseList(head);
        Node temp = head;
        // Set carry to 1, to add 1 to the last node
        int carry = 1;
        while (temp != null) {
            int sum = temp.data + carry; // calculate sum of temp's data + carry
            carry = sum / 10; // Extract carry 
            temp.data = sum % 10; // Overwrite temp's data
            if (carry == 0) break; // If carry is 0, it means no further changes reqd so exit early
            if (temp.next == null && carry == 1) { // if its the last node, and still carry is 1, add a new node with data as 1 and exit
            temp.next = new Node(carry); 
            break;
            }
            temp = temp.next; // go to next node
        } 
        head = reverseList(head); // Reverse the LL before returning the ans
        return head;
    }
}

// T.C => O(3 * n)
// S.C => O(1)
