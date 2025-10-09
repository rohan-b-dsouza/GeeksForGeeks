// Better

class Solution {
  public int celebrity(int[][] M) {
    int n = M.length;
    Deque<Integer> stack = new ArrayDeque<>();
    // Push all elements in the stack
    for (int i = 0; i < n; i++) {
      stack.push(i);
    }
    // Now till the stack has only one element left, perform pairwise elimination
    while (stack.size() > 1) {
      // Pop the first 2 elements and store in 'A' and 'B'
      int A = stack.pop();
      int B = stack.pop();
      // If 'A' knows 'B', B is the potential celebrity, hence push 'B' back to the stack
      if (M[A][B] == 1) {
        stack.push(B);
        // Else 'A' is the potential celebrity, hence push 'A' back to the stack
      } else {
        stack.push(A);
      }
    }

    // Get the potential celebrity (i.e the remaining one element in the stack) and check if its really a celebrity
    int cand = stack.pop();
    for (int i = 0; i < n; i++) {
        // If i == cand, it means its the same person hence skip this iteration
        if (i == cand) continue;
        // If 'cand' is not known by someone or if 'cand' knows someone, then return -1 as its not a celebrity
        if (M[i][cand] == 0 || M[cand][i] == 1) {
            return -1;
        }
    }
    // Else return 'cand' as its the celebrity
    return cand;
  }
}

// T.C => O(n) + O(n) + O(n) = O(3 * n) = O(n)
// S.C => O(n)
