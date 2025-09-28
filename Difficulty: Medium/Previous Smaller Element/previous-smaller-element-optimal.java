// Optimal (Monotonic Increasing Stack)

class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // If stack is not empty and stack's peek is greater than current element, pop the stack's top
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            // If stack is empty then add -1 as PSE of current element
            if(stack.isEmpty()) list.add(-1); 
            // Else add stack's top as PSE of current element
            else list.add(stack.peek());
            // Push current element to the stack
            stack.push(arr[i]);
        }
        // Return the answer
        return list;
        
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(2 * n) = O(n)
