// Better

class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        int n = stations.length;
        // Creates a PriorityQueue (maxheap) of double stationsay 
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        int[] howManySections = new int[n - 1];   //  storing no of sections between each element
        for (int i = 0; i < n - 1; i++) {
            pq.offer(new double[] {(double) stations[i + 1] - stations[i], i}); // add all {dist, index} pairs to pq
        }
        for (int j = 1; j <= k; j++) {
            double[] top = pq.poll(); // pops and returns top of pq
            int topIdx = (int) top[1];
            howManySections[topIdx]++; // updates sections
            // calculate new section len as we added new gas station
            double newSecLen = ((double) stations[topIdx + 1] - stations[topIdx]) / (howManySections[topIdx] + 1);
            pq.offer(new double[] {newSecLen, topIdx}); // add new section len to pq
        }
        return pq.poll()[0];
        
    }
}

// T.C => O(n * log(n)) + O(k * log(n))
// S.C => O(n - 1) + O(n - 1) => O(n - 1)



