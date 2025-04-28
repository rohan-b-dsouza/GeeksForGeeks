// Optimal Solution =>

class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long cnt = 0;
        int xor = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (map.containsKey(xor ^ k)) {
                cnt += map.get(xor ^ k);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
                

        }
        return cnt;
        
    }
}

// T.C => O(n)
// S.C => O(1)
