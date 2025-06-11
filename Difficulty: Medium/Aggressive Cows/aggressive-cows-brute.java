// Brute

class Solution {
    public boolean canWeAssignCows(int[] nums, int mindist, int cows) {
        int lastcow = nums[0];
        int cowsAssigned = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - lastcow) >= mindist) {
                lastcow = nums[i];
                cowsAssigned++;
            }
            if (cowsAssigned == cows) return true;
        }
        return false;
    }
    public int aggressiveCows(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[n - 1];
        int min = nums[0];
        if (k == 2) return max - min;
        for (int i = 1; i <= max - min; i++) {
            if (!canWeAssignCows(nums, i, k)) {
                return i - 1; 
            }
        }
        return -1;
    }
}


// T.C =>O(n log(n)) +  O((max - min) * n) =>  O((max - min) * n)
// S.C => O(1)
