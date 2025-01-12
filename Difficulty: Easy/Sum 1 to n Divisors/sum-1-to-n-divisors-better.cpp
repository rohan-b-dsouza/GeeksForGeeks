class Solution {
  public:
    int sum = 0;
    int sumOfDivisors(int n) {
        for (int i = 1; i <= n; i++) {
            sum += i * (n / i);
        }
        return sum;
    }
};
