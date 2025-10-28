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
    public boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
    public void addLeftBoundary(Node node, List<Integer> ans) {
        Node curr = node;
        while(curr != null) {
            if (!isLeaf(curr)) ans.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public void addLeaves(Node node, List<Integer> ans) {
        if (node.left == null && node.right == null) {
            ans.add(node.data);
            return;
        }
        if (node.left != null) addLeaves(node.left, ans);
        if (node.right != null) addLeaves(node.right, ans);
    }
    public void addRightBoundary(Node node, List<Integer> ans) {
        Node curr = node;
        List<Integer> tempRightBoundary = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) tempRightBoundary.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for (int i = tempRightBoundary.size() - 1; i >= 0; i--) {
            ans.add(tempRightBoundary.get(i));
        }
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        if (!isLeaf(root)) ans.add(root.data);
        addLeftBoundary(root.left, ans);
        addLeaves(root, ans);
        addRightBoundary(root.right, ans);
        return ans; 
    }
}