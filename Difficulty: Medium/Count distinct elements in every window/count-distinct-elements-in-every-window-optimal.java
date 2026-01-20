// Optimal (Sliding window approach for constant window)

// Logic:- First get the freq of elements for the first k sized window
// Now, add the size of the map to the answer.
// Now, iterate from k to n, and for each next window, decrement the freq of element at i - k, i.e first element of previous window.
// If while removing element's freq becomes 0, remove it from the map.
// Add the new element on the right. 
// Add the size of map to the answer

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }
        ans.add(map.size());
        for (int i = k; i < n; i++) {
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            if (map.get(arr[i - k]) == 0) map.remove(arr[i - k]);
            map.merge(arr[i], 1, Integer::sum);
            ans.add(map.size());
        }
        return ans;
        
    }
}

// T.C => O(n)
// S.C => O(n)
