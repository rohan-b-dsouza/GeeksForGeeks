// Optimal 

// Logic:- Similar to Sum of Subarray Minimums

class Solution {
    public int[] getpgee(int[] arr, int n) {
        int[] pgee = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            pgee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pgee;
    } 
    public int[] getNge(int[] arr, int n) {
        int[] nge = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nge;
    }
    public int sumOfMax(int[] arr) {
        int n = arr.length;
        int[] pgee = getpgee(arr, n);
        int[] nge = getNge(arr, n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;
            sum += (left * right * arr[i]);
        }
        return sum;
    }
}

// T.C => O(5 * n) = O(n)
// S.C => O(4 * n) = O(n)
