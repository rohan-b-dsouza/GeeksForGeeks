// Optimal
// n and v both represent no. of vertices

class Solution {
    boolean isColourPossible(int node, int color, int[] colorsMap, List<List<Integer>> adjacencyList) {
        // checking if adjacent nodes are coloured with current color
        for (int i = 0; i < adjacencyList.get(node).size(); i++) { 
            int adjacentNode = adjacencyList.get(node).get(i);
            if (colorsMap[adjacentNode] == color) return false;
        }
        return true;
    }
    boolean solveMColourProblem(int node, int n, int m, List<List<Integer>> adjacencyList, int[] colorsMap) {
        // Base Case : if all nodes are safely coloured then node will equal n hence return true
        if (node == n) {
            return true;
        }
        // For each node, we explore all paths (i.e try colouring with all colours)
        for (int color = 1; color <= m; color++) {
            // if this color is possible then mark the node with that color in colorsMap
            if (isColourPossible(node, color, colorsMap, adjacencyList)) {
                colorsMap[node] = color;
                // Recursively try colouring further nodes
                // if all nodes are safely coloured it will return true, hence return true
                if (solveMColourProblem(node + 1, n, m, adjacencyList, colorsMap)) {
                    return true;
                }
                // backtrack by unmarking node's color to explore other paths 
                colorsMap[node] = 0;
            }
        }
        return false; // no colour can be assigned to that node
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        // fill adjacencyList with n empty lists (n is no. of nodes)
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        // fill the adjacencyList with the edges
        // since its an undirected graph for each edge add both directions (eg (0,1) and (1,0))
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        int[] colorsMap = new int[v];
        return solveMColourProblem(0, v, m, adjacencyList, colorsMap);
        
    }
}


// T.C => O(m^n) as there are m color choices for n nodes
// S.C => O(n) recursion stack + O(n) colorsMap + O(n + 2*E) (adjacency list has n inner lists and total 2*E cells where E is no. of edges) -----{2*E because each edge is stored twice (both directions)}
