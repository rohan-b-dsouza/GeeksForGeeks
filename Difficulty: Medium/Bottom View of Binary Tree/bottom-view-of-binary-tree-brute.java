// Brute (Level Order Traversal)
// Same solution as that of the Problem 'Top View of BT'. Just change the statement map.putIfAbsent(col, node.data); to map.put(col, node.data) because we want the last node of every column instead of first 
// Refer the problem top view for well - commented code

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

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
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            int col = pair.col;
            map.put(col, node.data);
            if (node.left != null) queue.offer(new Pair(node.left, col - 1));
            if (node.right != null) queue.offer(new Pair(node.right, col + 1));
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
       ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        levelOrderTraversal(root, map);
        for (var colEntry : map.entrySet()) {
            ans.add(colEntry.getValue());
        }
        return ans;
        
    }
}

// T.C => O(N * log (N))
// S.C => O(2 * N) => O(N) for TreeMap and Deque
