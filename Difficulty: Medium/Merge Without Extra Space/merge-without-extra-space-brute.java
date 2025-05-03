// Brute-Force (Using Extra Space)

// User function Template for Java

class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;
        int[] temp = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                temp[k++] = a[i++];
            }
            else {
                temp[k++] = b[j++];
            } 
        }
        while (i < n) {
            temp[k++] = a[i++];
        }
        while (j < m) {
            temp[k++] = b[j++];
        }
        for (int l = 0; l < n + m; l++) {
            if (l < n) {
                a[l] = temp[l];
            }
            else {
                b[l - n] = temp[l];
            }
        }
        
    }
}
 
// T.C => O(n+m) + O(n+m) = O(2 * (n+m)) = O(n+m)
// S.C => O(n+m) for the extra array 'temp'
