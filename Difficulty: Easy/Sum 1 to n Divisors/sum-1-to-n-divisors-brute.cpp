class Solution {
  public:
    int sum = 0;
    int sumOfDivisors(int n) {
        for (int i = 1; i <= n; i++) { // T.C => O(n)
            for (int j = 1; j * j <= i; j++) { // T.C => O(n * sqrt(n)) 
                if (i % j == 0) {
                   sum += j;
                   if (i / j != j) sum += i / j;
                }
            }
        }
        return sum;
    }
};

// T.C => O(n * sqrt(n)) 
// S.C => O(1)
