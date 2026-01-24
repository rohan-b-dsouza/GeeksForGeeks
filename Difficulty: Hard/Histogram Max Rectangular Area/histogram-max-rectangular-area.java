class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int idx = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = (int) Math.max((nse - pse - 1) * 1L * arr[idx], maxArea); 
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = (int) Math.max((nse - pse - 1) * 1L * arr[idx], maxArea);
        }
        return maxArea;
    }
}
