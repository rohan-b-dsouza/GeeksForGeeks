class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) list.add(-1);
            else list.add(stack.peek());
            stack.push(arr[i]);
        }
        Collections.reverse(list);
        return list;
        
    }
}