// Better (Refer Leetcode version of this problem 'Online Stock Span' which has a slight design twist)

class Solution {
    public int[] preGreaterEle(int[] arr) {
       int n = arr.length;
       int[] pge = new int[n];
       Deque<Integer> stack = new ArrayDeque<>();
       for (int i = 0; i < n; i++) {
           // If stack is not empty and stack's peek is smaller than or equal to current element, then pop stack's pop
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
           // If stack is empty, set -1 as the PGE index of current element
            if (stack.isEmpty()) pge[i] = -1;
            // Else stack's top is the PGE of current element
            else pge[i] = stack.peek();
           // Push the current element's index to the stack
            stack.push(i);
       }
        // Return the list
       return pge;
    }
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        // Get PGE array of 'arr'
        int[] pge = preGreaterEle(arr);
        // For each element, get its span using (i - index of its previous greater element)
        for (int i = 0; i < n; i++) {
            ans.add(i - pge[i]);
        }
        // Return ans
        return ans;
    }
}

// T.C => O(2 * n) + O(n) = O(3 * n) = O(n)
// S.C => O(2 * n) + O(n) = O(3 * n) = O(n) (However O(n) in calculateSpan function is needed to store the 'ans' so its negligible)
