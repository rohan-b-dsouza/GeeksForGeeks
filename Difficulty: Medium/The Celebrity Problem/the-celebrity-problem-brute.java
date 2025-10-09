// Brute

class Solution {
    public int celebrity(int[][] M) {
      int n = M.length;
    // Array that tracks how many people know a person
      int[] knowsMe = new int[n];
        // Array that tracks how many people a person knows
      int[] Iknow = new int[n];
      // Iterate over the entire array and set the above two arrays
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            // If i == j it means its the same person hence skip this iteration
            if (i == j) continue;
            // If i knows j, increment the count of people knowing j and increment the count of people i knows 
            if (M[i][j] == 1) {
                knowsMe[j]++;
                Iknow[i]++;
            }
        }
      }
        // Now, traverse from 0 to n - 1
      for (int i = 0; i < n; i++) {
          // For each person check if its known by all other people (i.e n - 1) and also check if it doesn't know anyone else. If so then this is the celebrity
        if (knowsMe[i] == n - 1 && Iknow[i] == 0) {
            return i;
        } 
      }
        // If no celebrity found, return -1
      return -1;
    }
}

// T.C => O(n ^ 2) + O(n)
// S.C => O(2 * n) = O(n)
