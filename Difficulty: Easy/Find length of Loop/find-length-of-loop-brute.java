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
        // HashMap to store visited nodes and the cumulative length
        HashMap<Node, Integer> map = new HashMap<>();
        while (temp != null) {
            cnt++;
            // If a node is visited already, then loop is detected hence return the running length - cumulative length of that current node
            if (map.containsKey(temp)) {
                return cnt - map.get(temp);
            }
            // Put the node and its cumulative length in the map
            map.put(temp, cnt);
            temp = temp.next;
        }
        return 0;
    }
}

// T.C => O(n)
// S.C => O(n) for the hashmap used
