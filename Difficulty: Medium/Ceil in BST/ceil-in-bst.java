/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        // Get the root node and initialize ceil to -1
        Node node = root;
        int ceil = -1;
        // While node is not null
        while (node != null) {
            // If node's data is greater than equal to key
            if (node.data >= x) {
                // Get the ceil
                ceil = node.data;
                // Move left as we want the smallest value greater than key
                node = node.left;
            }
            // Else move right
            else {
                node = node.right;
            }
        }
        // Return ceil
        return ceil;
        
    }
}

// T.C => O(h) ---------------- {h = log (n) for balanced BST, h = n for skewed BST}
// S.C => O(1)