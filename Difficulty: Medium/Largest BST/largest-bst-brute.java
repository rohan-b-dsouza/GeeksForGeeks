// Brute

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    // Function that counts the nodes in a tree given the root
    static int countNodes(Node root) {
    if (root == null) return 0;
    return 1 + countNodes(root.left) + countNodes(root.right); 
  }
  // Function to check if the BST is valid
  static boolean isValidBST(Node root, int min, int max) {
    if (root == null) return true;
    if (root.data <= min || root.data >= max) {
      return false;
    }
    return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
  }
    static int largestBst(Node root) {
    // If root is null, return 0
    if (root == null) return 0;
    // If its a valid BST, return the count of its nodes
    if (isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
        return countNodes(root);
    }
    // Recursively call the left and right subtree to get the largest BST
    return Math.max(largestBst(root.left), largestBst(root.right));
        
    }
}

// T.C => O(n ^ 2)
// S.C => O(3 * n) = O(n)
