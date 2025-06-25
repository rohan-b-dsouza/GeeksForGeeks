// Optimal

class Solution {
  public int getNumberOftargetSumSubsequences(int index, int target, int n, int[] nums) {
    if (index == n) {
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
