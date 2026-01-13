// User function Template for Java

class Solution {
    public boolean checkDuplicates(int arr[]) {
        // Code here
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.contains(arr[i])) return true;
            st.add(arr[i]);
        }
        return false;
    }
}