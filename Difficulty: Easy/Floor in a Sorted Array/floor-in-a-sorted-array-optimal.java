// Optimal 

class Solution {

    static int findFloor(int[] arr, int x) {
        // write code here
        int floor = -1;
        int low = 0;
        int high = arr.length - 1;
         while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                floor = mid;
                low = mid + 1;
            }
            else   {
                high = mid - 1;
            }
        }
        return floor;
    }
}

// T.C => O(log(n))
// S.C => O(1)
