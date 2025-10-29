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
            map.putIfAbsent(col, node.data);
            if (node.left != null) queue.offer(new Pair(node.left, col - 1));
            if (node.right != null) queue.offer(new Pair(node.right, col + 1));
        }
    }
    public ArrayList<Integer> topView(Node root) {
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