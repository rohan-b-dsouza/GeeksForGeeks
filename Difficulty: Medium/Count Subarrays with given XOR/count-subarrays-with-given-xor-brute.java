// Brute - Solution =>

class Solution {
    public long subarrayXor(int arr[], int k) {
        int n = arr.length;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                for (int l = i; l <= j; l++) {
                    xor ^= arr[l];
                }
                if (xor == k) cnt++;
            }
        }
        return cnt;
    }
}

// T.C => O(n^3)
// S.C => O(1)
