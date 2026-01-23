// Optimal (BFS - Kahn's Algorithm)

// Logic:- We know that Topological sort is eligible only for a DAG. Hence, if a directed graph has cycles its topological sort will be incorrect and its size will be < V.
// Therefore, we just call the topoSort() function which gives us the count of the topological sort. If its < V, a cycle is detected, else not.

class Solution {
    public int topoSort(int V, List<List<Integer>> adj) {
    int[] indegree = new int[V];
    int[] visited = new int[V];
    int ans = 0;
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < V; i++) {
      for (int node : adj.get(i)) {
        indegree[node]++;
      }
    }
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    int j = 0;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      ans++;
      visited[node] = 1;
      for (int currNode : adj.get(node)) {
        if (visited[currNode] != 1) {
          indegree[currNode]--;
          if (indegree[currNode] == 0) queue.offer(currNode);
        }
      }
    }
    return ans;
  }
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        if (topoSort(V, adj) != V) return true;
        return false;
    }
}

// T.C => O(V + E)
// S.C => O(V + E)
