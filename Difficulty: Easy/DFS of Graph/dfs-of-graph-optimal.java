// Depth First Search

class Solution {
    public void dfs(int V, ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> ans, int currNode) {
        // Add current node to the ans list
        ans.add(currNode);
        // Recursively call dfs on all nodes connected to current node
        for (int node : adj.get(currNode)) {
            // If node is not visited then call dfs on it
            if (visited[node] != 1) {
                // Mark node as visited
                visited[node] = 1;
                // Call dfs on it
                dfs(V, adj, visited, ans, node);
            }
        }}
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] visited = new int[V];
        // Mark node 0 as visited
        visited[0] = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(V, adj, visited, ans, 0);
        return ans;
    }
}

// T.C => O(V + E)
// S.C => O(V) (recursion stack + visited array)
