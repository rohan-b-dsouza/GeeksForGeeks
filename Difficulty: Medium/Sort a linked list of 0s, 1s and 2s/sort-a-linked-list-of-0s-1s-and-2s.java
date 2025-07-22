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
       if (head == null || head.next == null) return head;
        Node dummyzero = new Node(-1);
        Node dummyone = new Node(-1);
        Node dummytwo = new Node(-1);
        Node zero = dummyzero;
        Node one = dummyone;
        Node two = dummytwo;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            }
            else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            }
            else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = dummyone.next == null ? dummytwo.next : dummyone.next;
        one.next = dummytwo.next;
        two.next = null;
        return dummyzero.next;
    }
}