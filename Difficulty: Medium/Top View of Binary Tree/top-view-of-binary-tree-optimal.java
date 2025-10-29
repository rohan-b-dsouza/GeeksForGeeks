// Optimal 
// Same as brute just change TreeMap to HashMap, track min and max col throughout the traversal, iterate over the map from min to max to fetch the top view nodes

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

// Pair to store the <node, col> pairs
class Pair {
    Node node;
    int col;
    Pair(Node node, int col) {
        this.node = node;
        this.col = col;
    }  
}

class Solution {
    public ArrayList<Integer> topView(Node root) {
      // List to store the answer
        ArrayList<Integer> ans = new ArrayList<>();
        // If tree is empty, return empty list
        if (root == null) return ans;
        // HashMap to store the <col, node's data> pairs
        HashMap<Integer, Integer> map = new HashMap<>();
        // min and max variable track the minimum and maximum column seen throughout the tree
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // Queue for level order traversal
        Deque<Pair> queue = new ArrayDeque<>();
        // Put the root node along with col as 0 to the queue
        queue.offer(new Pair(root, 0));
        // While queue is empty
        while(!queue.isEmpty()) {
            // Get the pair from the queue's front
            Pair pair = queue.poll();
            // Get the node and col value
            Node node = pair.node;
            int col = pair.col;
            // Update min and max col
            min = Math.min(min, col);
            max = Math.max(max, col);
            // Put the <col, node's data> pair to the map
            map.putIfAbsent(col, node.data);
            // If left node is present add it to the queue with decremented col value
            if (node.left != null) queue.offer(new Pair(node.left, col - 1));
            // If right node is present add it to the queue with incremented col value
            if (node.right != null) queue.offer(new Pair(node.right, col + 1));
        }
        // Iterate over the map from min to max keys to get the top view order
        for (int key = min; key <= max; key++) {
            // Add the top view nodes to ans
            ans.add(map.get(key));
        }
        // Return ans
        return ans;
    }
}

// T.C => O(N) as we visit each nodes exactly once and HashMap retrieval and insertion is O(1) unlike the brute force version
// S.C => O(N) for queue in worst case (All last level nodes are present i.e N / 2 nodes) + O(N) for the HashMap
