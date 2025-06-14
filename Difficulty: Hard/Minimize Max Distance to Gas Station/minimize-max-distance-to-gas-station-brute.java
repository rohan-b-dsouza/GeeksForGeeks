// Brute


class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        int n = stations.length;
        int howManySection[] = new int[n - 1];
        for (int i = 1; i <= k; i++) {
            double maxDist = -1;
            int sectionIndex = -1;
            for (int j = 0; j < n - 1; j++) {
                double sectionLength = ((double) stations[j + 1] - stations[j]) / (howManySection[j] + 1);
                if (sectionLength > maxDist) {
                    maxDist = sectionLength;
                    sectionIndex = j;
                }
            }
            howManySection[sectionIndex]++;
        }
        double result = -1;
        for (int i = 0; i < n - 1; i++)  {
            double sectionDist = ((double) stations[i + 1] - stations[i]) / (howManySection[i] + 1);
            result = Math.max(result, sectionDist);
        }
        return result;
        
    }
}

// T.C => O()
// S.C => O()
