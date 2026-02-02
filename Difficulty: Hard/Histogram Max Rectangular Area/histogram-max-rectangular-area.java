class Solution {
    public static int getMaxArea(int arr[]) {
        // code here
        int n = arr.length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int idx = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int bars = (nse - pse)- 1;
                ans = Math.max(ans, arr[idx] * bars);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
               int idx = stack.pop();
                int nse = n;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int bars = (nse - pse) - 1;
                ans = Math.max(ans, arr[idx] * bars);
        }
        return ans;
    }
}
