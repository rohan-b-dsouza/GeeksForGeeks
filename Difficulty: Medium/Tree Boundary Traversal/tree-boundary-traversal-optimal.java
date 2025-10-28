// Optimal

/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    // Returns whether a node is a leaf node
    public boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
    // Add the left boundary
    public void addLeftBoundary(Node node, List<Integer> ans) {
        Node curr = node;
        // While curr is not null
        while(curr != null) {
            // If current node is not a leaf node, add it to the left boundary
            if (!isLeaf(curr)) ans.add(curr.data);
            // If current node has a left node, move to left node
            if (curr.left != null) curr = curr.left;
            // Else move to right node
            else curr = curr.right;
        }
    }
    // Add the leaf nodes
    public void addLeaves(Node node, List<Integer> ans) {
        // If current node has no left as well as right child add it to the answer
        if (node.left == null && node.right == null) {
            ans.add(node.data);
            return;
        }
        // If left child exists move to left child
        if (node.left != null) addLeaves(node.left, ans);
        // If right child exists move to right child
        if (node.right != null) addLeaves(node.right, ans);
    }
    // Add the right boundary
    public void addRightBoundary(Node node, List<Integer> ans) {
        // Get the current node
        Node curr = node;
        // Define a temporary list to store the right boundary
        List<Integer> tempRightBoundary = new ArrayList<>();
        // If current is not null
        while (curr != null) {
            // If current node is not a leaf node, add it to the temporary list
            if (!isLeaf(curr)) tempRightBoundary.add(curr.data);
            // If right node exists, move to right
            if (curr.right != null) curr = curr.right;
            // Else move to left
            else curr = curr.left;
        }
        // Add the right boundary by taking nodes from temporary list in reverse order
        for (int i = tempRightBoundary.size() - 1; i >= 0; i--) {
            ans.add(tempRightBoundary.get(i));
        }
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
         // List to store the answer   
        ArrayList<Integer> ans = new ArrayList<>();
        // If root is null, return empty list
        if (root == null) return ans;
        // If root node itself is leaf node then don't add it to the answer as addLeaves() will also do it
        if (!isLeaf(root)) ans.add(root.data);
        // Add left boundary, then leaf nodes, then right boundary
        addLeftBoundary(root.left, ans);
        addLeaves(root, ans);
        addRightBoundary(root.right, ans);
        // Return ans
        return ans; 
    }
}

// T.C => O(3 * n) = O(n) 
// S.C => O(2 * n) = O(n)----------{Recursive stack space for the addLeaves() function, and O(n) for the temporary list}
