class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int n = arr.length;
        int cnt = 0;
        int maxCnt = Integer.MIN_VALUE;
        while (i < n) {
            if (arr[i] <= dep[j]) {
                cnt++;
                i++;
            }
            else {
                cnt--;
                j++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
        
    }
}



// T.C => O(2 * (n * log (n))) + O(2 * n) = O(n * log(n))
// S.C => O(1)
