// Better - Solution =>

class Solution {
    int maxLen(int arr[]) {
        // code here
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    int len = j - i + 1;
                    maxlen = Math.max(maxlen, len);
                }
            }
        }
        return maxlen;
    }
}

// T.C => O(n^2)
// S.C => O(1)
