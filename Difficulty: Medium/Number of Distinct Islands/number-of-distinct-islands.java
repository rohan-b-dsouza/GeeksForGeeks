// User function Template for Java
class Pair {
    int row, col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}


class Solution {
    
    public void bfs(int i, int j, int n, int m, int[][] visited, int[][] grid, StringBuilder path, Set<String> set) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(i, j));
        path.append(0).append(',').append(0).append('|');
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1 && visited[r][c] != 1) {
                    visited[r][c] = 1;
                    queue.offer(new Pair(r, c));
                    path.append(r - i).append(',').append(c - j).append('|');
                }
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
      int m = grid[0].length;
      Set<String> set = new HashSet<>();
      int[][] visited = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1 && visited[i][j] != 1) {
                StringBuilder path = new StringBuilder();
                visited[i][j] = 1;
                bfs(i, j, n, m, visited, grid, path, set);
                set.add(path.toString());
            }
        }
      }
      return set.size();
        
    }
}
