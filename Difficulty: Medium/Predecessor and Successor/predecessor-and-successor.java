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
        return ans;
    }
}