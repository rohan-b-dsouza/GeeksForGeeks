// User function Template for Java

class Solution {
    public static boolean checkSum(int index, int k, int[] arr, int n) {
        if (k == 0) {
            return true;
        }
        if (k < 0 || index == n) {
            return false;
        }
        return checkSum(index + 1, k - arr[index], arr, n) || checkSum(index + 1, k, arr, n);
    }
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        return checkSum(0, K, arr, N);
    }
}
