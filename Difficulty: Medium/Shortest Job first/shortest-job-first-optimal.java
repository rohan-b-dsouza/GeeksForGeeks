// Optimal (This problem is exactly the implementation of SJF (Non - preemptive))
// Note:- Arrival time for all processes is 0 as per problem
// This is written exactly like the SJF non - preemptive algorithm

class Solution {
    static int solve(int[] bt) {
        Arrays.sort(bt);
        int n = bt.length;
        int sum = 0;
        int totalWaitingTime = 0;
        for (int i = 0; i < n; i++) {
            sum += bt[i]; // exit time of current process
            totalWaitingTime += (sum - bt[i]); // add waiting time of current process (W.T = T.A.T - B.T) as A.T = 0 for all processes therefore, T.A.T = E.T -> hence, W.T = E.T - B.T
        }
        return Math.floorDiv(totalWaitingTime, n);
    }
}

// Commonly used way -> (However, both are eventually the same)

class Solution {
    static int solve(int[] bt) {
        Arrays.sort(bt);
        int n = bt.length;
        int totalTime = 0;
        int waitingTime = 0; // waiting time for first process is 0
        for (int i = 0; i < n; i++) {
            waitingTime += totalTime; // add waiting time for current process
            totalTime += bt[i]; // store cumulative waiting time
        }
        return Math.floorDiv(waitingTime, n);
    }
}

// T.C => O(n * log(n) + O(n)) => O(n * log (n))
// S.C => O(1)
