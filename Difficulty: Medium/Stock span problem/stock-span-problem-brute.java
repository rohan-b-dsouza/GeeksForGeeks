// Brute (Refer Leetcode version of this problem 'Online Stock Span' which has a slight design twist)

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
      ArrayList<Integer> ans = new ArrayList<>();
        // For each element, iterate from it till its last smallest element on left to get the span for this element and then add to the ans
        for (int i = 0; i < n; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) break;
                span++;
            }
            ans.add(span);
        }
        return ans;
        
    }
}

// T.C => O(n ^ 2)
// S.C => O(n) -----{However, its negligible because its used to store the 'ans' not to solve the problem}
