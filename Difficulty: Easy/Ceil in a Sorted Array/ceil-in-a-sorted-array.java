// User function Template for Java
class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int ceil = -1;
        int low = 0;
        int high = arr.length - 1;
         while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ceil = mid;
                high = mid - 1;
            }
            else   {
                low=mid+1;
            }
        }
        return ceil;
    }
}
