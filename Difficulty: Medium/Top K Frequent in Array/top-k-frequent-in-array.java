class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            int compare =  Integer.compare(map.get(a), map.get(b));
            if (compare != 0) return compare;
            return Integer.compare(a, b);
        });
        for (int key: map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }
        while(!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
