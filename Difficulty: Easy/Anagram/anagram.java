class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        int[] str1 = new int[26];
        int[] str2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            str1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            str2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (str1[i] != str2[i]) return false;
        }
        return true;
    }
}