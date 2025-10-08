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
        int[] pge = preGreaterEle(arr);
        for (int i = 0; i < n; i++) {
            ans.add(i - pge[i]);
        }
        return ans;
        
    }
}







// class Solution {
//     public ArrayList<Integer> calculateSpan(int[] arr) {
//         int n = arr.length;
//       ArrayList<Integer> ans = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             int span = 1;
//             for (int j = i - 1; j >= 0; j--) {
//                 if (arr[j] > arr[i]) break;
//                 span++;
//             }
//             ans.add(span);
//         }
//         return ans;
        
//     }
// }


