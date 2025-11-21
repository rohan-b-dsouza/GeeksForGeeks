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

class NodeValue {
  public int size, min, max;

  NodeValue(int size, int min, int max) {
    this.size = size;
    this.min = min;
    this.max = max;
  }
}

class Solution {

    static NodeValue largestBSTSubtreeHelper(Node root) {
    if (root == null) {
        return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    NodeValue left = largestBSTSubtreeHelper(root.left);
    NodeValue right = largestBSTSubtreeHelper(root.right);
    if (left.max < root.data && root.data < right.min) {
        return new NodeValue(
            1 + left.size + right.size,
            Math.min(left.min, root.data),
            Math.max(right.max, root.data)
        );
    }
    return new NodeValue(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);

  }
    
    
    static int largestBst(Node root) {
        // Write your code here
        return largestBSTSubtreeHelper(root).size;
    }
}