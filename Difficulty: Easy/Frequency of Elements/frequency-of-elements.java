class Solution {
    public ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }
        for (Integer key : map.keySet()) {
            ans.add(new ArrayList<>(Arrays.asList(key, map.get(key))));
        }
        return ans;
    }
}