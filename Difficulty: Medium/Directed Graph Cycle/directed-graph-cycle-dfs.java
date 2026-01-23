// Optimal

// Logic:- Just perform simple dfs but for each node mark it as 2 meaning that it is visited in current path, and while backtracking remark it to 1, meaning its only visited.
// This ensures that next path doesn't consider this as revisited i.e its again found in the same path. It makes sure its fresh for new path.
// However, if we mark a node as 2, and again its found while recursing itself then its a cycle.

class Solution {
    public boolean dfs(int node, List<List<Integer>> adj, int[] visited) {
      visited[node] = 2;
      for (int currNode : adj.get(node)) {
        if (visited[currNode] == 2) return true;
        else if (visited[currNode] == 0) {
          if (dfs(currNode, adj, visited)) return true;
        }
      }
      visited[node] = 1;
      return false; 
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
      int[] visited = new int[V];
      for (int i = 0; i < V; i++) {
        if (visited[i] == 0) {
          if (dfs(i, adj, visited)) return true;   
        }
      }
      return false;
    }
}

// T.C => O(V + E)
// S.C => O(V + E)
