// Optimal (BFS - Kahn's Algorithm)

// Logic :- Firstly, we put all the nodes with indegree 0 into the queue. This is because nodes with indegree 0 means that no nodes are dependent on these.
// Now, we take out nodes one by one from the queue, and decrement the indegree of nodes connected to this popped node. This is because since the node is popped and added to answer now its not dependent on its adjacent nodes.
// At any step, if indegree of a node becomes zero, we put it into the queue.

class Solution {
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
        int[] indegree = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visited = new int[V];
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
        while(!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);
            for (int currNode : adj.get(node)) {
                    indegree[currNode]--;
                    if (indegree[currNode] == 0) queue.offer(currNode);
            }
        }
        return ans;
    }
}

// T.C => O(V + E)
// S.C => O(V + E) adj list + O(V) indegree array + O(V) visited array + O(V) queue = O(V + E)
