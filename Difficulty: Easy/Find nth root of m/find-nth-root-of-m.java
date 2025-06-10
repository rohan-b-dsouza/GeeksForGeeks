// User function Template for Java

class Solution {
    public int power(int x, int n) {
        int ans = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                ans = ans * x;
                n = n - 1;
            }
            else {
                x*=x;
                n = n / 2;
            }
        }
        return ans;
    }
    public int nthRoot(int n, int m) {
        
        for (int i = 1; i <= m ; i++) {
            int expo = power(i, n);
            if (expo == m) return i;
            if (expo > m) break;
        }
        return -1;
    }
}
