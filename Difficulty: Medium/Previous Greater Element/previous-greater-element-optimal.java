// Optimal

class Solution {
    static ArrayList<Integer> preGreaterEle(int[] arr) {
       int n = arr.length;
       ArrayList<Integer> list = new ArrayList<>();
       Stack<Integer> stack = new Stack<>();
       for (int i = 0; i < n; i++) {
           // If stack is not empty and stack's peek is smaller than or equal to current element, then pop stack's pop
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
           // If stack is empty, -1 is the PGE of current element
            if (stack.isEmpty()) list.add(-1);
            // Else stack's top is the PGE of current element
            else list.add(stack.peek());
           // Push the current element to the stack
            stack.push(arr[i]);
       }
        // Return the list
       return list;
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(2 * n) = O(n)
