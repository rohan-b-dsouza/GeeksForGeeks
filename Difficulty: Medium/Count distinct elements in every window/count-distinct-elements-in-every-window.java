class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int r = k; r < n; r++) {
            ans.add(map.size());
            map.put(arr[l], map.get(arr[l]) - 1);
            if (map.get(arr[l]) == 0) map.remove(arr[l]);
            l++;
            map.merge(arr[r], 1, Integer::sum);
        }
        ans.add(map.size());
        return ans;
    }
}