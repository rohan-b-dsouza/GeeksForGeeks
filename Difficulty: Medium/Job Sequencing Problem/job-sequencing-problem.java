import java.util.*;

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;

        // Prepare jobs as [id, deadline, profit]
        int[][] Jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            Jobs[i][0] = i + 1;      // Job ID (1-based)
            Jobs[i][1] = deadline[i];
            Jobs[i][2] = profit[i];
        }

        // Sort jobs by profit descending
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        // Find maximum deadline
        int maxDeadline = -1;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, Jobs[i][1]);
        }

        // Array to mark allocated slots
        int[] jobDeadlineMap = new int[maxDeadline + 1];
        Arrays.fill(jobDeadlineMap, -1);

        int cntJobs = 0;
        int maxProfit = 0;

        // Schedule jobs
        for (int i = 0; i < n; i++) {
            int j = Jobs[i][1];
            // Find the latest available slot <= deadline
            while (j > 0 && jobDeadlineMap[j] != -1) {
                j--;
            }
            if (j > 0) {
                jobDeadlineMap[j] = Jobs[i][0]; // Allocate job
                cntJobs++;
                maxProfit += Jobs[i][2];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(cntJobs);
        result.add(maxProfit);
        return result;
    }
}
