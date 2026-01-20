class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        int cnt = 0;
        int maxcnt = 1;
        int i = 0;
        int lastIdx = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (i < n) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch) || (map.containsKey(ch) && (map.get(ch) < lastIdx))) {
                cnt++;
            }
            else {
                cnt = (i - map.get(ch));
                lastIdx = map.get(ch) + 1;
            }
            maxcnt = Math.max(maxcnt, cnt);
            map.put(ch, i);
            i++;
        }
        return maxcnt;
    }
}