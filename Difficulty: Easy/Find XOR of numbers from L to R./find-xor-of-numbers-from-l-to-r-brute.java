// Brute

class Solution {
    public int findRangeXOR(int l, int r) {
         int xor = 0;
         for (int i = l; i <= r; i++) {
            xor ^= i;
         }
         return xor;
    }
}

// T.C => O(r - l + 1)
// S.C => O(1)
