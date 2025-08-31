// Greedy Approach
// Note :- Optimal Solution is using Disjoint Sets (Graph Topic) Hence, use Disjoint Sets for scheduling jobs in this solution after studying Disjoint Sets

import java.util.*;

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;

        // Create an array of indices
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        // Sort indices based on profit descending
        Arrays.sort(idx, (a, b) -> Integer.compare(profit[b], profit[a]));
        /*
        Arrays.sort(idx, (a, b) -> profit[b] - profit[a]);
        This is also allowed, but use of Integer.compare() helps in avoid overflow issues 
        */
        // Find maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        // Array to mark allocated slots
        int[] jobDeadlineMap = new int[maxDeadline + 1];
        Arrays.fill(jobDeadlineMap, -1);

        int cntJobs = 0;
        int maxProfit = 0;

        // Schedule jobs
        for (int i = 0; i < n; i++) {
            int j = deadline[idx[i]];
            // Find the latest available slot <= deadline
            while (j > 0 && jobDeadlineMap[j] != -1) j--;
            if (j > 0) {
                jobDeadlineMap[j] = idx[i]; // Allocate job
                cntJobs++;
                maxProfit += profit[idx[i]];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(cntJobs);
        result.add(maxProfit);
        return result;
    }
}

// T.C => O(n * log (n)) for sorting and approx. O(n^2) for scheduling jobs
// S.C => O(n)
