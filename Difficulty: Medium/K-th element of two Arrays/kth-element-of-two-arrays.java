// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
         int n1 = a.length;
    int n2 = b.length;
    while (n1 > n2)
      return kthElement(b, a, k); // for better T.C we want first array to be of smaller size
    int n = n1 + n2;
    int low = Math.max(0, k - n2);
    int high = Math.min(n1, k);
    int left = k;
    while (low <= high) {
      int mid1 = (low + high) / 2;
      int mid2 = left - mid1;
      int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
      int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
      int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
      int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

      if (l1 <= r2 && l2 <= r1) { // we got the required symmetry
        return Math.max(l1, l2);
      } else if (l1 > r2) high = mid1 - 1;
      else low = mid1 + 1;
    }
    return 0;
    }
}