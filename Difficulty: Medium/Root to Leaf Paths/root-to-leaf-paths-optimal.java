// Optimal (DFS - Inorder Traversal)

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
    // Add current node to the path and if its a leaf node add the path to the ans list
    path.add(node.data);
    if (node.left == null && node.right == null) {
      ans.add(new ArrayList<>(path));
    }
    // Else
    else {
    // If left node is present move left
    if (node.left != null) getAllPaths(node.left, path, ans);
    // If right node is present move right
    if (node.right != null) getAllPaths(node.right, path, ans);
    }
    // Backtrack by removing the last added node to the path
    path.remove(path.size() - 1);
  }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
   // List to store the answer
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    // If tree is empty return empty list
    if (root == null) return ans;
    // List to store the path
    ArrayList<Integer> path = new ArrayList<>();
    // Call the recursive function
    getAllPaths(root, path, ans);
    // Return ans
    return ans;
    }
}

// T.C => O(n + L * h) as we visit each node once and when we reach leaf node we need O(L * h) for creating list 
// S.C => O(h) for the path list and O(h) for the recursive stack  
// Also ----{h = n for skewed B.T, h = log (n) for balanced B.T}
