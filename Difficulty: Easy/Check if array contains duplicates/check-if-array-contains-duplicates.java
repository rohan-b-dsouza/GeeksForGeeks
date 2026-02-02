// User function Template for Java

class Solution {
    public boolean checkDuplicates(int arr[]) {
        // Code here
        int n = arr.length;
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (st.contains(arr[i])) return true;
            st.add(arr[i]);
        }
        return false;
    }
}