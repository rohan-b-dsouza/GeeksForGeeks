// Optimal

class Solution {
    public static boolean checkSum(int index, int k, int[] arr, int n) {
        if (k == 0) {  // Base case: if the sum k is 0, a subsequence is found
            return true;
        }
        if (k < 0 || index == n) {  // Base case: if k is negative or index has reached n, no valid subsequence can be found
            return false;
        }
        // Recursive call: include the current element in the subsequence
        // or exclude the current element from the subsequence
        return checkSum(index + 1, k - arr[index], arr, n) || checkSum(index + 1, k, arr, n);
    }
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        return checkSum(0, K, arr, N);
    }
}

// T.C => O(2^n)
// S.C => O(n)
