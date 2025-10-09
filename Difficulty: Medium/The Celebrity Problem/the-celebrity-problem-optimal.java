// Optimal
// This solution is same like the better but instead of using a stack we use a 'stack' and track the potential celebrity on the go

class Solution {
    public int celebrity(int[][] M) {
      int n = M.length;
      // Initialize 'cand' as 0 
      int cand = 0;
      // Now iterate from 1 to n, and perform elimination by comparing 'cand' with i
      for (int i = 1; i < n; i++) { 
        // If 'cand' knows i, update 'cand' to i else continue
        if (M[cand][i] == 1) {
            cand = i;
        }
      }
      // Now, check if 'cand' is really the celebrity
      for (int i = 0; i < n; i++) {
        // If i == cand, it means its the same person, hence skip this iteration
        if (i == cand) continue; 
        // If 'cand' knows someone or someone doesn't know 'cand', return -1 as 'cand' is not a celebrity
        if (M[cand][i] == 1 || M[i][cand] == 0) return -1;
      }
      // Else return 'cand' as its a celebrity
      return cand;
    }
}

// T.C => O(n) + O(n) = O(2 * n) = O(n)
// S.C => O(1)
