class Solution {
    public int[] getPsee(int[] arr, int n) {
        int[] psee = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return psee;
    }
    public int[] getNse(int[] arr, int n) {
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
    public int sumSubMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;
        int[] psee = getPsee(arr, n);
        int[] nse = getNse(arr, n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            sum = (sum + (left * 1L * right * arr[i]) % MOD) % MOD;
        }
        return (int) (sum);
    }
}
