// Optimal Solution => (Prefix Sum Method)

class Solution {
    int maxLen(int arr[]) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxlen = Math.max (maxlen, i + 1);
            }
            else if (map.containsKey(sum)) {
                int len = i - map.get(sum); 
                maxlen = Math.max (maxlen, len);
            }
            else {
                map.put(sum, i);
            }
        }
        return maxlen;
    }
}

// T.C => O(n)
// S.C => O(n) for the hashmap used
