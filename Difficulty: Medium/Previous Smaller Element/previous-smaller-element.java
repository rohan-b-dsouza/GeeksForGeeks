class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) list.add(-1); 
            else list.add(stack.peek());
            stack.push(arr[i]);
        }
        return list;
        
    }
}