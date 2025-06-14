// Brute (Same as Split Array Largest Sum Problem and Painter Partition Problem)

class Solution {
    public int noOfStudentAllocated (int[] nums, int maxPages, int m) {
        int n = nums.length;
        int pages = nums[0];
        int studcnt = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] + pages <= maxPages) {
                pages += nums[i];
            }
            else {
                pages = nums[i];
                studcnt++;
            }
        }
        return studcnt;
    }

    public int findPages(int[] nums, int m) {
        int n = nums.length;
        if (m > n) return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(nums[i], low);
            high += nums[i];
        }
        for (int i = low; i <= high; i++) {
            if (noOfStudentAllocated(nums, i, m) <= m) {
                return i;
            }
        }
        return -1;     
    }

    
}

// T.C => O((sum - max) * n)  where n is size of array 
// S.C => O(1)
