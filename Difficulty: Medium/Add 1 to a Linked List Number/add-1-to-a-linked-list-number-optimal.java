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
        if (head == null) return head;
        head =  reverseList(head);
        Node temp = head;
        int carry = 1;
        while (temp != null) {
            int sum = temp.data + carry;
            carry = sum / 10;
            temp.data = sum % 10;
            if (carry == 0) break;
            if (temp.next == null && carry == 1) {
            temp.next = new Node(carry);
            break;
            }
            temp = temp.next;
        } 
        head = reverseList(head);
        return head;
    }
}

// T.C => O(3 * n)
// S.C => O(1)
