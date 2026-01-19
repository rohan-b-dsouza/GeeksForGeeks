class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        int n = arr.length;
        int maxlen = 1;
        int len = 1;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if(arr[i + 1] - arr[i] == 1) len++;
            else if (arr[i + 1] - arr[i] == 0) continue;
            else len = 1;
            maxlen = Math.max(maxlen, len);
        }
        return maxlen;
    }
}