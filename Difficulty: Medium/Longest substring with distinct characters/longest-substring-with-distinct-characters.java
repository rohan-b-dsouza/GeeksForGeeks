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