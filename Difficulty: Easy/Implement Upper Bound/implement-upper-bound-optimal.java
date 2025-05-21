// Optimal Solution 

class Solution {
    int upperBound(int[] arr, int target) {
        
        int ans = arr.length;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
        int mid = (low + high) / 2;

        if (arr[mid] > target) {
            ans = mid;
            
            high = mid - 1;
        }
        else {
            low = mid + 1; 
    }
        
        
   }
        return ans;
    }}

// T.C => O(logn)
// S.C => O(1)
