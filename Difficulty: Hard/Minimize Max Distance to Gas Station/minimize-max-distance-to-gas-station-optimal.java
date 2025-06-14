// Optimal

class Solution {
    
     public static int  numberOfGasStationsRequired(int[] stations, double dist) {
        int cnt = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            int numberOfStationsInBetween = (int) ((stations[i + 1] - stations[i]) / dist);
            if ((stations[i + 1] - stations[i]) == (dist * numberOfStationsInBetween)) {
                numberOfStationsInBetween--;
            }
            cnt +=  numberOfStationsInBetween;
        }
        return cnt;
    } 
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        double low = 0;
        int n = stations.length;
        double high = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(stations[i + 1] - stations[i], high);
        }    
        while ((high - low ) > 1e-6) {
            double mid = (low + high) / 2;
            if (numberOfGasStationsRequired(stations, mid) > k) {
                low = mid;
            } 
            else {
                high = mid;
            }
        }
        return high;
    }
}

// T.C => O(log(len) * n) + O(n) => O(log(len) * n)  ------- { where n is size of array and len is length of the answer space }
// S.C => O(1)
