// Optimal

class Solution {
  public int getNumberOftargetSumSubsequences(int index, int target, int n, int[] nums) {
    if (index == n) { // Base Case : Checks if valid subsequence is found (Also handles case where array has zeroes)
        return (target == 0) ? 1 : 0; 
    }
    // Recursive Case : Include element in subsequence or exclude it
    return getNumberOftargetSumSubsequences(index + 1, target - nums[index], n, nums)
        + getNumberOftargetSumSubsequences(index + 1, target, n, nums);
  }

  public int perfectSum(int[] nums, int target) {
    int n = nums.length;
    return getNumberOftargetSumSubsequences(0, target, n, nums);
  }
}

// T.C => O(2 ^ n)
// S.C => O(n)

// If array has no zeroes, then instead of the if condition used in above solution we can use -
// if (k == 0) { // Base case: if sum is 0, one valid subsequence is found, count++;
//             return 1;
//         }
// if (k < 0 || index == n) { // Base Case : No valid subsequence found
//             return 0;
// }
// This code exits early in each recursive step whenever k < 0 or if valid subsequence is found

