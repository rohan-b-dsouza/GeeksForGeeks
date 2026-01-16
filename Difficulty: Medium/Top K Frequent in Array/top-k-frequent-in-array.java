class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) ->{
                int cmp = Integer.compare(map.get(a), map.get(b));
                if (cmp != 0) return cmp;
                return Integer.compare(a, b);
            }
        );
        for (int key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while(!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
