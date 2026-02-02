class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        int n = s1.length();
        if (n != s2.length()) return false;
        int[] hash = new int[26];
        for (int i = 0; i < n; i++) {
            hash[s1.charAt(i) - 'a']++;
            hash[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) return false;
        } 
        return true;
    }
}