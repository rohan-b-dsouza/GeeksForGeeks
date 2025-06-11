// Optimal 

class Solution {
    public static boolean canWeAssignCows(int[] stalls, int minDist, int cows) {
    int lastcow = stalls[0];
    int cowsAssigned = 1;
    for (int i = 1; i < stalls.length; i++) {
      if ((stalls[i] - lastcow) >= minDist) {
        lastcow = stalls[i];
        cowsAssigned++;
      }
      if (cowsAssigned == cows) return true;
    }
    return false;
  }
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
    int low = 1;
    Arrays.sort(stalls);
    int high = stalls[n - 1];
    int min = stalls[0];
    if (k == 2) return high - min;
    high = high - min; // as high = max - min,
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (canWeAssignCows(stalls, mid, k)) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return high;
        
    }
}

// T.C => O(n log (n)) + O(log(max - min) * n) => O(log(max - min) * n) ----------{where n is size of array}
// S.C => O(1)
