class Solution {
    boolean twoSum(int arr[], int target) {
        int n = arr.length;
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < n;i++) {
            if (st.contains(target - arr[i])) return true;
            st.add(arr[i]);
        }
        return false;
    }
}