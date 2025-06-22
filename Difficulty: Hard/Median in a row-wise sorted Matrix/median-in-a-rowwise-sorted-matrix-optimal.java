// Optimal

class Solution {
  public int upperBound(int[] arr, int target) {
    int ans = arr.length;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;

      if (arr[mid] > target) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  public int countSmallerEqual(int[][] mat, int mid, int m) {
    int cntSmallerEquals = 0;
    for (int i = 0; i < m; i++) {
      cntSmallerEquals += upperBound(mat[i], mid);
    }
    return cntSmallerEquals;
  }

  int median(int mat[][]) {
    int m = mat.length;
    int n = mat[0].length;
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      low = Math.min(low, mat[i][0]);
      high = Math.max(high, mat[i][n - 1]);
    }
    int reqd = (m * n) / 2;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (countSmallerEqual(mat, mid, m) > reqd) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}

// T.C => O((log (max - min)) * m * log (n))
// S.C => O(1)
