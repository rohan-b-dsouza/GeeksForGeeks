// Optimal 

class Solution {
    public int findKRotation(List<Integer> arr) {
     int low = 0;
    int result = Integer.MAX_VALUE;
    int high = arr.size() - 1;
    int index = 0;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr.get(low) <= arr.get(high)) {
        if (arr.get(low) < result) {
          index = low;
          result = arr.get(low);
        }
        break;
      }
      if (arr.get(mid) >= arr.get(low)) {
        if (arr.get(low) < result) {
          result = arr.get(low);
          index = low;
        }
        low = mid + 1;
      } else {
        if (arr.get(mid) < result) {
          result = arr.get(mid);
          index = mid;
        }
        high = mid - 1;
      }
    }
    return index;
        
    }
}

// T.C => O(log(n))
// S.C => O(1)



