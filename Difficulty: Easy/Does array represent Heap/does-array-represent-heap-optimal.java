// Optimal

class Solution {

    public boolean countSub(long arr[], long n) {
        // Iterate over the internal nodes
        for (int i = 0; i <= n / 2 - 1; i++) {
            // For each internal node, check whether its left and right child are greater, if so return false as max-heap property is not satisfied
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if ((left < n && arr[left] > arr[i]) || (right < n && arr[right] > arr[i])) return false;
        }
        // Return true
        return true;
    }
}

// T.C => O(n)
// S.C => O(1)
