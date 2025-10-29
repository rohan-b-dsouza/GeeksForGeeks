// Brute

/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

// Stores <node, col> pair
class Pair {
    Node node;
    int col;
    Pair(Node node, int col) {
        this.node = node;
        this.col = col;
    }  
}

class Solution {
    public void levelOrderTraversal(Node root, TreeMap<Integer, Integer> map) {
        // Deque for level order traversal
        Deque<Pair> queue = new ArrayDeque<>();
        // Put the pair <root, 0> to the queue
        queue.offer(new Pair(root, 0));
        // While queue is not empty
        while(!queue.isEmpty()) {
            // Get the pair from the front of the queue
            Pair pair = queue.poll();
            // Get the node and col
            Node node = pair.node;
            int col = pair.col;
            // If this col key is not present in the map, create it and put its value as popped node's data
            map.putIfAbsent(col, node.data);
            // If left node is present add it to the queue along with decremented col
            if (node.left != null) queue.offer(new Pair(node.left, col - 1));
            // If right node is present add it to the queue along with its incremented col
            if (node.right != null) queue.offer(new Pair(node.right, col + 1));
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // List to store the answer
        ArrayList<Integer> ans = new ArrayList<>();
        // If root is null, return ans
        if (root == null) return ans;
        // TreeMap that stores the <col, node>  pairs
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Perform the level order traversal 
        levelOrderTraversal(root, map);
        // Get the map's entry set
        for (var colEntry : map.entrySet()) {
            // Add the current entry's value to the answer
            ans.add(colEntry.getValue());
        }
        // Return ans
        return ans;
    }
}

// T.C => O(N * log(N))
// S.C => O(N) for the TreeMap and O(N) for the queue (Worst Case : Last level has all nodes present i.e O(N / 2)) => O(2 * N) => O(N)
