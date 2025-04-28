// Brute - Force =>

class Solution {
    int maxLen(int arr[]) {
        int n = arr.length;
        int maxcnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                int cnt = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    cnt++;
                }
                if (sum == 0) {
                    maxcnt = Math.max(maxcnt, cnt);
                }
            }
        }
        return maxcnt;
    }
    
}

// T.C => O(n^3)
// S.C => O(1)
