// Optimal (Sweep Line Algorithm) (Two-Pointer Approach)
// A sweep line algorithm processes events in sorted order by “sweeping” a line across a timeline or space to track overlaps or active elements.

class Solution {
    public int minPlatform(int arr[], int dep[]) {
        // Sort both the arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int n = arr.length;
        int cnt = 0;
        int maxCnt = Integer.MIN_VALUE;
        // Sweep through the timeline of events (arrivals and departures) 
        while (i < n) {
            // If a train arrives before the departure of previous then assign it a new platform
            if (arr[i] <= dep[j]) {
                cnt++;
                i++;
            }
                // If a train arrives after the departure of another train, then decrement the platform count as new platform is not reqd
            else {
                cnt--;
                j++;
            }
            // At each step track the maximum platform count to get the minimum no. of platforms reqd
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
        
    }
}


// T.C => O(2 * (n * log (n))) + O(2 * n) = O(n * log(n))
// S.C => O(1)
