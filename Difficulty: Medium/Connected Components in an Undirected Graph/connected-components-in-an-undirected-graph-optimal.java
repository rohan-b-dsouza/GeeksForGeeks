// Optimal (BFS & DFS version both included)

class Solution {
    // Get the dfs of current component
    public void dfsOfGraph(int currNode, ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> componentList) {
        componentList.add(currNode);
        visited[currNode] = 1;
        for (int node : adj.get(currNode)) {
            if (visited[node] != 1) {
                dfsOfGraph(node, adj, visited, componentList);
            }
        }
    }
    // Get the bfs of current component
    public void bfsOfGraph(int sourceNode, ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> componentList) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(sourceNode);
        visited[sourceNode] = 1;
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            componentList.add(currNode);
            for (int node : adj.get(currNode)) {
                if (visited[node] != 1) {
                    queue.offer(node);
                    visited[node] = 1;
                }
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] visited = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // Since edge list is given, build the adjacency list using it
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // For every unvisited vertice build the component list using either bfs or dfs.
        // Every unvisited vertex encountered in this loop, corresponds to a new component
        for (int i = 0; i < V; i++) {
            // If vertex is not visited it means this corresponds to a new component hence build the component list for this component using either bfs or dfs
            if (visited[i] != 1) {
                ArrayList<Integer> componentList = new ArrayList<>();
                bfsOfGraph(i, adj, visited, componentList);
                ans.add(new ArrayList<>(componentList));
                // dfsOfGraph(i, adj, visited, componentList);
                // ans.add(new ArrayList<>(componentList));
            }
        }
        // Return ans
        return ans;
    }
}

// 1. BFS version :- 

// T.C ⇒ O(V + E) for building adjacency list + O(V + E) for traversal

// S.C ⇒ O(V + E) for adjacency list + O(2 * V) for visited array & queue

// 1. DFS version:- 

// T.C ⇒ O(V + E) for building adjacency list + O(V + E) for traversal

// S.C ⇒ O(V + E) for adjacency list + O(2 * V) for recursion stack & visited array
