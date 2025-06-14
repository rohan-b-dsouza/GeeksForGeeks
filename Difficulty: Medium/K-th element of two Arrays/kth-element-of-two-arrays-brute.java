// Brute

class Solution {
    public int kthElement(int a[], int b[], int k) {
    int n = a.length;
    int m = b.length;
    List<Integer> mergedArr = new ArrayList<>();
    int left = 0;
    int right = 0;
    while (left < n && right < m) {
      if (a[left] <= b[right]) {
        mergedArr.add(a[left]);
        left++;
      } else {
        mergedArr.add(b[right]);
        right++;
      }
    }
    while (left < n) {
      mergedArr.add(a[left]);
      left++;
    }
    while (right < m) {
      mergedArr.add(b[right]);
      right++;
    }
    return mergedArr.get(k - 1);
    }
}

// T.C => O(n + m)
// S.C => O(n + m)
