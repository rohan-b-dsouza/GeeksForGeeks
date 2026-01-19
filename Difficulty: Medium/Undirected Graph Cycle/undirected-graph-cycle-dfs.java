// Optimal

class Pair {
    int node;
    int parent;

  Pair(int node, int parent) {
    this.node = node;
    this.parent = parent;
  }
}

// Logic:- Same as bfs solution just replaced with dfs instead of bfs

class Solution {
    public boolean dfs(int sourceNode, List<List<Integer>> adj, int[] visited, int parent) {
    visited[sourceNode] = 1;
    for (int node : adj.get(sourceNode)) {
      if (visited[node] != 1) {
        boolean flag = dfs(node, adj, visited, sourceNode);
        if (flag) return true;
      }
      else if (node != parent) return true;
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
            if (dfs(i, adj, visited, -1)) return true;
        }
        }
        return false;
    }
}

// T.C => O(V + E)
// S.C => O(V + E)
