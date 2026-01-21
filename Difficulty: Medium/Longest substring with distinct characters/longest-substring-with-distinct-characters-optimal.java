// Optimal

// Logic:- Maintain a hash array to track index of each element.
// In each step, if the element is not present left pointer remains unchanged.
// If its already present, there are 2 cases :- 1. It's present within current substring. If yes, we set left pointer to one step ahead of the previous position of this element.
// 2. If its present before current substring, then we keep the left pointer as it is.
// Also, we update the index of each element in every step & also update the max length seen so far.

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        int[] hash = new int[26];
        int maxlen = 1;
        Arrays.fill(hash, -1);
        int l = 0;
        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            if (hash[ch - 'a'] != -1) {
                l = Math.max(l, hash[ch - 'a'] + 1);
            }
            hash[ch - 'a'] = r;
            maxlen = Math.max(maxlen, r - l + 1);
        }
        return maxlen;
    }
}

// T.C => O(n)
// S.C => O(26) = O(1)
