// Brute

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
        if (head == null) return 0;
        Node temp = head;
        int cnt = 0;
        HashMap<Node, Integer> map = new HashMap<>();
        while (temp != null) {
            cnt++;
            if (map.containsKey(temp)) {
                return cnt - map.get(temp);
            }
            map.put(temp, cnt);
            temp = temp.next;
        }
        return 0;
    }
}

// T.C => O(n)
// S.C => O(n) for the hashmap used
