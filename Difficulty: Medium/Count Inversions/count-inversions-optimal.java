// Optimal - Solution 

class Solution {
    
    static int merge(int arr[], int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            }
            else {
                list.add(arr[right]);
                cnt += mid - left + 1;
                right++;
            }
        }
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }
        while (right <= high) {
            list.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
        return cnt;
        
    }    

    static int mergeSort(int arr[], int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);   
        return cnt;
    }
    
    static int inversionCount(int arr[]) {
        int cnt = 0;
       cnt = mergeSort(arr, 0, arr.length - 1);
       return cnt;
        
    }
}

// T.C => O(n*log(n)) -----------------------{due to merge sort}
// S.C => O(n) for the extra list
