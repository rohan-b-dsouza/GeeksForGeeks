// User function Template for Java

// Optimal 

class Solution {
    public int power(int x, int n, int m) {
        int ans = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                ans = ans * x;
                if (ans > m) return -1;
                n = n - 1;
            }
            else {
                x*=x;
                if (ans > m) return -1;
                n = n / 2;
            }
        }
        if (ans == m) return 1;
        return 0;
    }
    public int nthRoot(int n, int m) {
        
         int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int expo = power(mid, n, m);
            if (expo == 1) return mid; // found exact root
            else if (expo == -1)  { 
                high = mid - 1; //  move left
            }
            else { 
                low = mid + 1; // move right
            }
        }
        return -1; // No integer root found
    }
}

// T.C => O(log(m) * log(n))
// S.C => O(1)
