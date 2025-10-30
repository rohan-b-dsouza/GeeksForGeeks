/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static void getAllPaths(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans) {
    path.add(node.data);
    if (node.left == null && node.right == null) {
      ans.add(new ArrayList<>(path));
      path.remove(path.size() - 1);
      return;
    }
    if (node.left != null) getAllPaths(node.left, path, ans);
    if (node.right != null) getAllPaths(node.right, path, ans);
    path.remove(path.size() - 1);
  }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    ArrayList<Integer> path = new ArrayList<>();
    getAllPaths(root, path, ans);
    return ans;
    }
}