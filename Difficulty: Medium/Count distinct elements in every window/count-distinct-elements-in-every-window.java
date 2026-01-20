class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
       int n = arr.length;
       ArrayList<Integer> ans = new ArrayList<>();
       Map<Integer, Integer> map = new HashMap<>();
       
       for (int i = 0; i < k; i++) {
           map.merge(arr[i], 1, Integer::sum);
       }
       int l = 0;
       int r = k - 1;
       while(l < n) {
        ans.add(map.size());
        if (map.get(arr[l]) == 1) {
            map.remove(arr[l]);
        }
        else map.put(arr[l], map.get(arr[l]) - 1);
        if (r < n - 1) r++;
        else break;
        map.merge(arr[r], 1, Integer::sum);
        l++;
       }
       return ans;
       
    }
}