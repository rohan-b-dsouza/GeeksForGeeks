// Brute

class Solution {
    int median(int mat[][]) {
            int m = mat.length;
      int n = mat[0].length;
      List<Integer> temp = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            temp.add(mat[i][j]);
        }
      }
      temp.sort(null);
      return temp.get((n * m) / 2);
        
    }
}

// T.C => O(m * n) + O((n * m) * log (n * m)) => O((n * m) * log (n * m))
// S.C => O(1)
