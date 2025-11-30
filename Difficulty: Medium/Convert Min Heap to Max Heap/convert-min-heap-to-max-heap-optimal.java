// Optimal (This problem is same as the problem 'Build a max-heap from the given array')

class Solution {
    static void heapifyDown(int[] arr, int ind, int n) {
	  // Get the left and right child
    int left = 2 * ind + 1;
    int right = 2 * ind + 2;
    // Set largest to ind initially
    int largest = ind;
    // If left is within bounds and left child is larger than largest
    // update largest
    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }
    // If right is within bounds and right child is larger than largest
    // update largest
    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }
    // Now if largest is equal to ind, it means the current node's 
    // left or right child are not larger or not present, hence we don't swap
    // Else, if largest is not equal to ind, it means we got a larger value
    // either from left or right child, hence swap.
    if (largest != ind) {
        int temp = arr[ind];
        arr[ind] = arr[largest];
        arr[largest] = temp;
        // After swapping call the heapifyDown function on largest to ensure further
        // max-heap is maintained
        heapifyDown(arr, largest, n);
    }
  }
    static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(arr, i, n);
        }
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        buildMaxHeap(arr);
    }
}

// T.C => O(n)
// S.C => O(log (n))
