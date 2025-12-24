class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] visited = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = 1;
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            ans.add(currNode);
            for (int node : adj.get(currNode)) {
                if (visited[node] != 1) {
                    queue.offer(node);
                    visited[node] = 1;
                }
            }
        }
        return ans;
    }
}