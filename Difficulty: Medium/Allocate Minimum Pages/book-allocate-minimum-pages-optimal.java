// Optimal (Same as Split Array Largest Sum Problem and Painter Partition Problem)

class Solution {
      public static int noOfStudentAllocated (int[] arr, int maxPages, int k) {
        int n = arr.length;
        int pages = arr[0];
        int studcnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] + pages <= maxPages) {
                pages += arr[i];
            }
            else {
                pages = arr[i];
                studcnt++;
            }
        }
        return studcnt;
    }
    public static int findPages(int[] arr, int k) {
       int n = arr.length;
        int low = Integer.MIN_VALUE;
        if (k > n) return -1;
        int high = 0;
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(arr[i], low);
            high += arr[i];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (noOfStudentAllocated(arr, mid, k) > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        } 
        return low;
        
    }
}

// T.C => O(log(sum(arr) - max(arr)) * n) where n is size of array
// S.C => O(1)

