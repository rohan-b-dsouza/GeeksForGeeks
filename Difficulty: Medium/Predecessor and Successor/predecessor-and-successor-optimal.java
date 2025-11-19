// Optimal (Same as the problem 'Ceil of BST' & 'Floor of BST' with minor changes, refer that problem and this problem will also be solved automatically)

/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    // Get the predecessor
    static Node findPredecessor(Node root, int key) {
        Node node = root;
        Node floor = null;
        while (node != null) {
            if (node.data < key) {
                floor = node;
                node = node.right;
            }
            else {
                node = node.left;
            }
        }
        return floor;
    }
    // Get the successor
    static Node findSuccessor(Node root, int key) {
        Node node = root;
        Node ceil = null;
        while (node != null) {
            if (node.data > key) {
                ceil = node;
                node = node.left;
            }
            else {
                node = node.right;
            }
        }
        return ceil;
    }
    ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(findPredecessor(root, key));
        ans.add(findSuccessor(root,key));
        // Return ans
        return ans;
    }
}

// T.C => O(2 * h) = O(h) -------- {h = log(n) for balanced BST, h = n for skewed BST}
// S.C => O(1)
