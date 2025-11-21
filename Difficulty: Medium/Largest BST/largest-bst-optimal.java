// Optimal

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

// Class that stores the tuple {maxsize, minimum value in the subtree, maximum value in the subtree} for each node
class NodeValue {
  public int size, min, max;

  NodeValue(int size, int min, int max) {
    this.size = size;
    this.min = min;
    this.max = max;
  }
}

class Solution {
    // Helper function that helps get the largest subtree size
    static NodeValue largestBSTSubtreeHelper(Node root) {
    // If root is null, return a tuple {0, MAX_VALUE, MIN_VALUE}
    if (root == null) {
        return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    // Get the left subtree's tuple and right subtree's tuple
    NodeValue left = largestBSTSubtreeHelper(root.left);
    NodeValue right = largestBSTSubtreeHelper(root.right);
    // Now check for current node whether the subtree of this node is a valid BST, if yes the return the following tuple
    if (left.max < root.data && root.data < right.min) {
        // Return the tuple {size of this subtree, the minimum value in this subtree, the maximum value in this subtree}
        return new NodeValue(
            1 + left.size + right.size,
            Math.min(left.min, root.data),
            Math.max(right.max, root.data)
        );
    }
    // If a subtree is not a valid BST, return the following tuple
    // Return the tuple {max sized BST seen on left and right, MIN_VALUE, MAX_VALUE} ---------- [Sending the MIN_VALUE for min and MAX_VALUE for max ensures that the further ancestors know that their child is an invalid BST, ensuring pruning]
    return new NodeValue(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
  } 
    static int largestBst(Node root) {
        // Return the max size for the final NodeValue() returned
        return largestBSTSubtreeHelper(root).size;
    }
}

// T.C => O(n)
// S.C => O(h) ------- {h = n for skewed BST, h = log (n) for balanced BST}
