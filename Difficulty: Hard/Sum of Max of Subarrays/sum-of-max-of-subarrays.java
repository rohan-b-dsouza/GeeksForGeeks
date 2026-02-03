class Solution {
    public int[] findNge(int[] arr, int n) {
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            
        while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
            stack.pop();
        }
        ans[i] = stack.isEmpty() ? n : stack.peek();
        stack.push(i);
        }
        return ans;
    }
    public int[] findPgee(int[] arr, int n) {
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
        while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
            stack.pop();
        }
        ans[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(i);
        }
        return ans;
    }
    public int sumOfMax(int[] arr) {
        // code hereint n = arr.length;
        int n = arr.length;
        int[] nge = findNge(arr, n);
        int[] pge = findPgee(arr, n);
        int sum = 0;
        for (int i = 0; i < n ;i++) {
            int left = i - pge[i];
            int right = nge[i] - i;
            int total = right * left;
            sum = sum + (total *  arr[i]);
        }
        return sum;
        
    }
}

