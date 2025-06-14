// Better 

class Solution {
    public int kthElement(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        int i = 0;
        int j = 0;
        int cnt = 0;
        while (i < n1 && j < n2) {
            if (a[i] <= b[j]) {
                if (cnt == k - 1)
                    return a[i];
                cnt++;
                i++;
            } else {
                if (cnt == k - 1)
                    return b[j];
                cnt++;
                j++;
            }
        }
        while (i < n1) {
            if (cnt == k - 1)
                return a[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == k - 1)
                return b[j];
            cnt++;
            j++;
        }
        return -1;
    }
    
}

// T.C => O(n1 + n2)
// S.C => O(1)
