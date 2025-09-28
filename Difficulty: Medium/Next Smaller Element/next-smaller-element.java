// Optimal

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            // If stack is not empty and stack's peek is greater than or equal to current element, then pop the stack's top
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            // If stack is empty, then -1 is the NSE of the current element
            if (stack.isEmpty()) list.add(-1);
            // Else NSE of the current element is stack's top
            else list.add(stack.peek());
            // Push current element to the stack
            stack.push(arr[i]);
        }
        // Reverse the list before returning as its not in the right order
        Collections.reverse(list);
        // Return the list
        return list;
        
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(2 * n) = O(n)
