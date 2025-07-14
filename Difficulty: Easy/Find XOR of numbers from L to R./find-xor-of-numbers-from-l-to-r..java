// User function Template for Java

class Solution {
    public static int getXorOfRange(int n) {
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        if (n % 4 == 3) return 0;
        return n; 
    }
    public static int findXOR(int l, int r) {
        return getXorOfRange(l - 1) ^ getXorOfRange(r);
    }
}




// class Solution {
//     public int findRangeXOR(int l, int r) {
//          int xor = 0;
//          for (int i = l; i <= r; i++) {
//             xor ^= i;
//          }
//          return xor;
//     }
// }