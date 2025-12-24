class Solution {
    public void dfs(int V, ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> ans, int currNode) {
        ans.add(currNode);
        for (int node : adj.get(currNode)) {
            if (visited[node] != 1) {
                visited[node] = 1;
                dfs(V, adj, visited, ans, node);
            }
        }}
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] visited = new int[V];
        visited[0] = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(V, adj, visited, ans, 0);
        return ans;
    }
}