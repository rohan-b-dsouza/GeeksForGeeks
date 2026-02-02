class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        Set<Integer> st = new HashSet<>();
        for (int num : arr) {
            st.add(num);
        }
        int max = 1;
        for (int num : st) {
            if (!st.contains(num + 1)) {
                int cnt = 1;
                int x = num - 1;
                while(st.contains(x--)) {
                    cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}