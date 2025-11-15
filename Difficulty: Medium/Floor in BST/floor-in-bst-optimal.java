// Optimal

/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static int floor(Node root, int x) {
        // Get the root node and initialize floor to -1
        Node node = root;
        int floor = -1;
        // While node is not null
        while (node != null) {
            // If node's data is smaller than equal to x
            if (node.data <= x) {
                // Store it in floor
                floor = node.data;
                // Move right as we are looking for maximum value that is smaller than equal to x
                node = node.right;
            }
            // Else move left
            else {
                node = node.left;
            }
        }
        // Return floor
        return floor;
    }
}

// T.C => O(h) --- {h = log (n) for a balanced BST and h = n for a skewed BST}
// S.C => O(1)
