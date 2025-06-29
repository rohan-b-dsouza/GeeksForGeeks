// Optimal

class Solution {
  public void getAllPossiblePaths(
    String path, int row, int col, int n, ArrayList<String> ans, int[][] maze) {
    if (row == n - 1 && col == n - 1) { // if rat reaches the end it means it was a successful path
      ans.add(path);
      return;
    }
    if (row < 0 || row > n - 1 || col < 0 || col > n - 1 || maze[row][col] != 1) { // if path is out of bounds or path is blocked
      return;
    }
    maze[row][col] = -1; // mark the current cell as visited
    getAllPossiblePaths(path + "U", row - 1, col, n, ans, maze); // Move up 
    getAllPossiblePaths(path + "D", row + 1, col, n, ans, maze); // Move down 
    getAllPossiblePaths(path + "L", row, col - 1, n, ans, maze); // Move left 
    getAllPossiblePaths(path + "R", row, col + 1, n, ans, maze); // Move right 
    maze[row][col] = 1; // backtrack by unmarking visited cell
  }

  public ArrayList<String> ratInMaze(int[][] maze) {
    int n = maze.length;
    ArrayList<String> ans = new ArrayList<>();
    if (maze[0][0] == 0 || maze[n-1][n-1] == 0) return new ArrayList<>();
    getAllPossiblePaths("", 0, 0, n, ans, maze);
    Collections.sort(ans); 
    return ans;
  }
}
