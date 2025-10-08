// Optimal 

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // If stack is not empty and current element is greater than or equal to stack's peek, 
            // pop stack's top and put add its span to the current element's span
            int span = 1; // Initialize span to 1 to count the current element itself
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                span += ans.get(stack.pop());
            }
            ans.add(span);
            // Push current element's index to the stack
            stack.push(i);
        }
        // Return the ans
        return ans;
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(2 * n) = O(n) -------- {Also, O(n) of 'ans' is negligible as its reqd to store the 'ans'}
