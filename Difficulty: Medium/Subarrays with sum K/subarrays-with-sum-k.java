class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int runsum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            runsum += arr[i];
            int reqd = runsum - k;
            cnt += map.getOrDefault(reqd, 0);
            map.merge(runsum, 1, Integer::sum);
        }
        return cnt;
    }
}