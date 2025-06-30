// Optimal

class Solution {
  public void getAllPossiblePaths(
      String path, int row, int col, int n, ArrayList<String> ans, int[][] maze) {
    if (row == n - 1 && col == n - 1) { // if rat reaches the end it means it was a successful path
      ans.add(path);
      return;
    }
    if (maze[row][col] != 1) { // if path is out of bounds or path is blocked
      return;
    }
    maze[row][col] = -1; // mark the current cell as visited
    if (row > 0) getAllPossiblePaths(path + "U", row - 1, col, n, ans, maze); // Move up
    if (row < n - 1) getAllPossiblePaths(path + "D", row + 1, col, n, ans, maze); // Move down
    if (col > 0) getAllPossiblePaths(path + "L", row, col - 1, n, ans, maze); // Move left
    if (col < n - 1) getAllPossiblePaths(path + "R", row, col + 1, n, ans, maze); // Move right
    maze[row][col] = 1; // backtrack by unmarking visited cell
  }

  public ArrayList<String> ratInMaze(int[][] maze) {
    int n = maze.length;
    ArrayList<String> ans = new ArrayList<>();
    if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) return new ArrayList<>();
    getAllPossiblePaths("", 0, 0, n, ans, maze);
    Collections.sort(ans);
    return ans;
  }
}

// T.C => O((4)^(n^2)) as in the worst case each cell is visited and 4 directions for each cell are tried (ignoring pruning)
// S.C => O(n^2) auxiliary space (recursion stack) + O(k * n^2) for output list
