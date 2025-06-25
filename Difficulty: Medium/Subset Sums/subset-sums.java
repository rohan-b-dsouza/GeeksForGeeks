// User function Template for Java//User function Template for Java
class Solution {
    public void getSubsetSum(int index, int sum, ArrayList<Integer> ans, int[] arr, int n) {
        if (index == n) { // add sum to list when a subset is formed
            ans.add(sum);
            return;
        }
        // Recursively include the current element in the sum
        getSubsetSum(index + 1, sum + arr[index], ans, arr, n);
        // Recursively exclude the current element from the sum
        getSubsetSum(index + 1, sum, ans, arr, n);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        getSubsetSum(0, 0, ans, arr, n);
        return ans;
        
    }
}
