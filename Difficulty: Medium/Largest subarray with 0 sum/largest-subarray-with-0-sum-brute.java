// Brute - Force =>

class Solution {
    int maxLen(int arr[]) {
        int n = arr.length;
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                int len = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    len++;
                }
                if (sum == 0) {
                    maxlen = Math.max(maxlen, len);
                }
            }
        }
        return maxcnt;
    }
    
}

// T.C => O(n^3)
// S.C => O(1)
