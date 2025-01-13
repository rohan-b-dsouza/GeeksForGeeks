class Solution {
  public:
    // Function to count the number of digits in n that evenly divide n
    int evenlyDivides(int n) {
        int original = n;
        int cnt = 0;
        while (n != 0) {
            int digit = n % 10;
            if ((digit != 0) && (original % digit == 0)) cnt++;
            n = n / 10;
        }
        return cnt;
        
    }
};

// T.C => O(log(n)) --------{log to the base 10 as n is divided by 10 repeatedly}
// S.C => O(1)
