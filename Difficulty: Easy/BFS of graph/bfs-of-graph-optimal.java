// Breadth first Search

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        // Array that tracks visited nodes
        int[] visited = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        // Add node 0 to the queue
        queue.offer(0);
        // Mark it as visited
        visited[0] = 1;
        // While queue is not empty
        while(!queue.isEmpty()) {
            // Remove the front node and put it into the ans list
            int currNode = queue.poll();
            ans.add(currNode);
            // For all nodes adjacent to currNode, mark them as visited and put them in the queue
            for (int node : adj.get(currNode)) {
                if (visited[node] != 1) {
                    queue.offer(node);
                    visited[node] = 1;
                }
            }
        }
        // Return ans
        return ans;
    }
}

// T.C => O(V + E)
// S.C => O(V)
