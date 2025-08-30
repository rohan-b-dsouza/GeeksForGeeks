// 

class Solution {
    static int solve(int[] bt) {
        Arrays.sort(bt);
        int n = bt.length;
        int sum = 0;
        int totalWaitingTime = 0;
        for (int i = 0; i < n; i++) {
            sum += bt[i]; // exit time of current process
            totalWaitingTime += (sum - bt[i]); // add waiting time of current process
        }
        return Math.floorDiv(totalWaitingTime, n);
    }
}
