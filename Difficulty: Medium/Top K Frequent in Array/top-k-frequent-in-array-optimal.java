// Optimal

// Logic:- Put the elements in a map as {element : freq}. Now, put each element in the priority queue (min heap) maintaining only k elements in the pq at each step.
// Finally we will have to top k frequent elements. The comparator of the pq first compares the elements on the basis of their frequency and if two elements have same frequency it compares them on the basis of their value.

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

// T.C => O(n) + O(n * log (k)) + O(k) + O(k) = O(n * log (k))
// S.C => O(n + k) for the map and the priority queue
