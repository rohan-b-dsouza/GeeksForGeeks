class Solution {
    public static String smallestWindow(String s, String p) {
        // code here
        int n = s.length();
        int m = p.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.merge(p.charAt(i), 1, Integer::sum);
        }
        int l = 0; int r = 0;
        int cnt = 0;
        int startIdx = -1;
        int endIdx = -1;
        int minLen = Integer.MAX_VALUE;
        while (r < n) {
            char ch = s.charAt(r);
            if (map.getOrDefault(ch, 0) > 0) cnt++;
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            while (cnt == m) {
                if (r - l + 1 < minLen) {
                 minLen = r - l + 1;
                 endIdx = r;
                 startIdx = l;
                }
                if (map.get(s.charAt(l)) >= 0) cnt--;
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                l++;
            }
            r++;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, endIdx + 1);
    }
}