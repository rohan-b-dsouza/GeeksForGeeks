

class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(arr[i]) - 1;

            if (arr[idx] < 0) {
                ans.add(idx + 1);   // duplicate found
            } else {
                arr[idx] = -arr[idx]; // mark visited
            }
        }
        return ans;
    }
}
