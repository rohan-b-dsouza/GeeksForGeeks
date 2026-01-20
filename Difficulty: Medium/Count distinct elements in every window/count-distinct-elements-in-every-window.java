class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
       int n = arr.length;
       ArrayList<Integer> ans = new ArrayList<>();
       Map<Integer, Integer> map = new HashMap<>();
       
       for (int i = 0; i < k; i++) {
           map.merge(arr[i], 1, Integer::sum);
       }
       int l = 0;
       for (int r = k; r <= n; r++) {
           ans.add(map.size());
           map.put(arr[l], map.get(arr[l]) - 1);
           if (map.get(arr[l]) == 0) map.remove(arr[l]);
           if (r < n) map.merge(arr[r], 1, Integer::sum);
           l++;
       }
       return ans;
       
    }
}