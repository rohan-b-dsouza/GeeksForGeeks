// Optimal

class Solution {
    public static boolean isPossible(int a, int b) {
        // If both traversals are same or if its a combination of preorder and postorder then return false, else return true
        return !((a == b) || (a == 1 && b == 3) || (a == 3 && b == 1));
    }
}

// T.C => O(1)
// S.C => O(1)
