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
        if (head == null) return head;
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                if (temp.prev == null && temp.next == null) return null;
                else if (temp.prev == null) {
                    Node newHead = head.next;
                    newHead.prev = null;
                    head.next = null;
                    head = newHead;
                    temp = newHead;
                }
                else if (temp.next == null) {
                    Node newTail = temp.prev;
                    newTail.next = null;
                    temp.prev = null;
                    temp = null;
                }
                else{
                    Node nextNode = temp.next;
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    temp.prev = null;
                    temp.next = null;
                    temp = nextNode;
                }
            }
            else temp = temp.next;
        }
        return head;
        
    }
}