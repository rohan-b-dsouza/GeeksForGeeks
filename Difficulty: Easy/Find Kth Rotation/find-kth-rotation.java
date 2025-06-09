// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        int minvalue = Integer.MAX_VALUE;
    int result = 0;
    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) < minvalue) {
        minvalue = arr.get(i);
        result = i;
      }
    }
    return result;
        
    }
}
