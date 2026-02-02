// Optimal

// Logic:- Since the problem guarantees that each number will appear atmost twice, on first occurence of a number we mark it as visited at its home index (value - 1).
// If a number was already marked, i.e value at home index < 0, we add it to the 'ans'

class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(arr[i]) - 1;
            if (arr[idx] < 0) {
                ans.add(idx + 1);
            }
            else {
                arr[idx] = -arr[idx];
            }
        }
        return ans;
    }
}

// T.C => O(n)
// S.C => O(1)
