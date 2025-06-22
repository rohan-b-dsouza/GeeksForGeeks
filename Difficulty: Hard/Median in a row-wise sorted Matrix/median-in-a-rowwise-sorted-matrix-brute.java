// Brute

class Solution {
    int median(int mat[][]) {
            int m = mat.length;https://github.com/rohan-b-dsouza/GeeksForGeeks/blob/main/Difficulty%3A%20Hard/Median%20in%20a%20row-wise%20sorted%20Matrix/median-in-a-rowwise-sorted-matrix-brute.java
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

// T.C => O(m * n) + O((m * n) * log (m * n)) => O((m * n) * log (m * n))
// S.C => O(1)
