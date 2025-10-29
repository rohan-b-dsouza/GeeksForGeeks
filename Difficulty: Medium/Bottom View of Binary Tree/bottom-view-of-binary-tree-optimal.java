// Optimal

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
    
    public ArrayList<Integer> bottomView(Node root) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    ArrayList<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    HashMap<Integer, Integer> map = new HashMap<>();
    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(root, 0));
    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      Node node = pair.node;
      int col = pair.col;
      min = Math.min(min, col);
      max = Math.max(max, col);
      map.put(col, node.data);
      if (node.left != null) queue.offer(new Pair(node.left, col - 1));
      if (node.right != null) queue.offer(new Pair(node.right, col + 1));
    }
    for (int i = min; i <= max; i++) {
      ans.add(map.get(i));
    }

    return ans;
    }
}

// T.C => O(N)
// S.C => O(2 * N) = O(N) for the HashMap and Deque
