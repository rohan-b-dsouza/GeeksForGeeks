// Brute

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
       int zeroes = 0; int ones = 0; int twos = 0;
        Node temp = head;
        // Count the no. of zeroes, ones, and twos
        while (temp != null) {
            if (temp.data == 0) zeroes++;
            else if (temp.data == 1) ones++;
            else twos++;
            temp = temp.next;
        }
        temp = head;
        
        // Overwrite node values based on the counts (first 0s, then 1s, then 2s)
        while (temp != null) {
            if (zeroes > 0) {
                temp.data = 0;
                zeroes--;
            }
            else if (ones > 0) {
                temp.data = 1;
                ones--;
            }
            else {
                temp.data = 2;
                twos--;
            }
            temp = temp.next;
        }
        return head;
        
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(1)
