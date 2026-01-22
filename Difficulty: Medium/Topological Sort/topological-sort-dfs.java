// Optimal

// Logic:- Just do a dfs on the graph and in each step while backtracking add the nodes to the stack.
// Finally, popping elements from the stack will give the topologically sorted order.
// This is because in each step we add node to the stack only when we go into depth of the graph and a node has no further children which ensures it doesn't come before other node.

class Solution {
    public void dfs(int sourceNode, ArrayList<ArrayList<Integer>> adj, Deque<Integer> stack, boolean[] visited) {
        for (int node : adj.get(sourceNode)) {
            if (!visited[node]) {
                dfs(node, adj, stack, visited);
            }
        }
        visited[sourceNode] = true;
        stack.push(sourceNode);

    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
            dfs(i, adj, stack, visited);
           }
        }
        while(!stack.isEmpty()) {
            ans.add(stack.poll());
        }
        return ans;
    }
}

// T.C => O(V + E)
// S.C => O(V) visited array + O(V) stack + O(V) recursion stack space + O(V + E) adj list = O(V + E)
