// Optimal (This problem is exactly the implementation of SJF (Non - preemptive))

// This is written exactly like the SJF non - preemptive algorithm
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

// Commonly used way -> (However, both are eventually the same)



// T.C => O(n)
// S.C => O(1)
