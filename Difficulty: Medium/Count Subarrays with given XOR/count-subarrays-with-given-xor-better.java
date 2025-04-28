// Better Solution =>

class Solution {
    public long subarrayXor(int arr[], int k) {
        int n = arr.length;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor ^= arr[j];
                if (xor == k) cnt++;
            }
        }
        return cnt;
    }
}

// T.C => O(n^2)
// S.C => O(1)
