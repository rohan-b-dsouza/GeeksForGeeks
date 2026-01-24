class Solution {
    public static int[] getPse(int[] arr, int n) {
        int[] pse = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
    public static int[] getNse(int[] arr, int n) {
        int[] nse = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        int[] pse = getPse(arr, n);
        int[] nse = getNse(arr, n);
        long maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            int totalRects = left + right - 1;
            maxArea = Math.max(totalRects * 1L * arr[i], maxArea);
        }
        return (int) maxArea;
    }
}
