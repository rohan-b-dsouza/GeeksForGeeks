class Pair {
    int node;
    int parent;

  Pair(int node, int parent) {
    this.node = node;
    this.parent = parent;
  }
}

class Solution {
    public boolean bfs(int sourceNode, List<List<Integer>> adj, int[] visited) {
    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(sourceNode, -1));
    visited[sourceNode] = 1;
    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int node = pair.node;
      int parent = pair.parent;
      for (int curr : adj.get(node)) {
        if (visited[curr] != 1) {
          visited[curr] = 1;
          queue.offer(new Pair(curr, node));
        } else if (curr != parent) return true;
      }
    }
    return false;
  }
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
        if (visited[i] != 1) {
            if (bfs(i, adj, visited)) return true;
        }
        }
        return false;
    }
}