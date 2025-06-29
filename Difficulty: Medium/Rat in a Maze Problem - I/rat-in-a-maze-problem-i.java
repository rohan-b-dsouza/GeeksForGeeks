
class Solution {
  public void getAllPossiblePaths(
    String path, int row, int col, int n, ArrayList<String> ans, int[][] maze) {
    if (row == n - 1 && col == n - 1) {
      ans.add(path);
      return;
    }
    if (row < 0 || row > n - 1 || col < 0 || col > n - 1 || maze[row][col] != 1) {
      return;
    }
    maze[row][col] = -1;
    getAllPossiblePaths(path + "U", row - 1, col, n, ans, maze);
    getAllPossiblePaths(path + "D", row + 1, col, n, ans, maze);
    getAllPossiblePaths(path + "L", row, col - 1, n, ans, maze);
    getAllPossiblePaths(path + "R", row, col + 1, n, ans, maze);
    maze[row][col] = 1;
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
