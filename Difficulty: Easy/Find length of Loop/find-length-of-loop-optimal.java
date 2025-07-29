// Optimal (Tortoise and Hare Algorithm)

/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        if (head == null || head.next == null) return 0;
        // Initialize two pointers fast and slow
        Node fast = head;
        Node slow = head;
        // Traverse the LL with the fast and slow pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast by two step
            slow = slow.next; // Move slow by one step
            // Check if slow and fast pointers meet, if so then loop is detected hence use fast or slow pointer to calculate the length of loop
            if (fast == slow) {
                int cnt = 1;
                slow = slow.next;
                while(slow != fast) {
                    slow = slow.next;
                    cnt++;
                }
                return cnt;
            }; // Loop is detected
        }
        // If fast reaches end of loop or null, there is no loop
        return 0;
    }
}


// T.C => O(n)
// S.C => O(1)
