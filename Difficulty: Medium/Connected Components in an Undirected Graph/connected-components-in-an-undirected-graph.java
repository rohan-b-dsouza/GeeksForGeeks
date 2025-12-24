class Solution {
    public void dfsOfGraph(int currNode, ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> componentList) {
        componentList.add(currNode);
        visited[currNode] = 1;
        for (int node : adj.get(currNode)) {
            if (visited[node] != 1) {
                dfsOfGraph(node, adj, visited, componentList);
            }
        }
    }
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
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 0; i < V; i++) {
            if (visited[i] != 1) {
                ArrayList<Integer> componentList = new ArrayList<>();
                bfsOfGraph(i, adj, visited, componentList);
                ans.add(new ArrayList<>(componentList));
                // dfsOfGraph(i, adj, visited, componentList)
                // ans.add(new ArrayList<>(componentList));
            }
        }
        return ans;
    }
}