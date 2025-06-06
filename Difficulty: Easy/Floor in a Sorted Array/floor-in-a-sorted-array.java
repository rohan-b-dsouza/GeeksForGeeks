class Solution {

    static int findFloor(int[] arr, int x) {
        // write code here
         for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] <= x) return i;
        }
        return -1;//
    }
}
