class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        int ans = 1;
        while (r < n) {
            char curr = s.charAt(r);
            if (map.containsKey(curr) && map.get(curr) >= l) {
                l = map.get(curr) + 1;
            }
            map.put(curr, r);
            ans = Math.max(r - l + 1, ans);
            r++;
        }
        return ans;
    }
}