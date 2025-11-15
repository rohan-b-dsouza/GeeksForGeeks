/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    public static int floor(Node root, int x) {
        Node node = root;
        int floor = -1;
        while (node != null) {
            if (node.data <= x) {
                floor = node.data;
                node = node.right;
            }
            else {
                node = node.left;
            }
        }
        return floor;
        
    }
}