// Optimal

// Logic:- Simple dfs with conditions:- 

// 0 → Not visited
// 2 → Visited and currently in recursion stack (current path)
// 1 → Visited and fully processed (backtracked)

// Why it works:

// If you ever reach a node with visited == 2, it means:
// You found a node already in the current DFS path, Cycle detected

// Marking back to 1 on backtracking ensures:
// Other DFS paths don’t falsely detect cycles

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
