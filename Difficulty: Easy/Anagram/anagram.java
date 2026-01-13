class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        if (s1.length() != s2.length()) return false;
        int[] str = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            str[s1.charAt(i) - 'a']++;
            str[s2.charAt(i) - 'a']--;
        }
        for (int num : str) {
            if (num != 0) return false;
        }
        return true;
    }
}