// Optimal (Sweep Line Algorithm) (Two-Pointer Approach)
// A sweep line algorithm processes events in sorted order by “sweeping” a line across a timeline or space to track overlaps or active elements.

class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int n = arr.length;
        int cnt = 0, maxCnt = 0;

        // Sweep through the timeline of events
        while (i < n) {
            if (arr[i] <= dep[j]) {  // arrival before departure → new platform needed
                cnt++;
                i++;
            } else {                 // departure → platform freed
                cnt--;
                j++;
            }
            maxCnt = Math.max(maxCnt, cnt); // track max platforms at any time
        }

        return maxCnt;
    }
}


// T.C => O(2 * (n * log (n))) + O(2 * n) = O(n * log(n))
// S.C => O(1)
