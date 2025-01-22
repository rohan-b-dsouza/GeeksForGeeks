//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


class Solution {
  public:
    vector<int> lcmAndGcd(int a, int b) {
       int x = a, y = b;
       // using euclidean algorithm to find gcd
       while (a != 0 && b != 0) {
           if (a > b) {
               a = a % b;
           }
           else b = b % a;
       }
       // lcm(a,b) = a * b / gcd(a, b)
       if (a == 0) { // if a == 0 then gcd = b
           int lcm = (x * y) / b; // as value of a and b gets changed while calculating gcd, therefore we store their
                                  // original values in x and y
           return {lcm, b};
       }
       else { // else gcd = a
           int lcm = (x * y) / a;
           return {lcm, a};
       }
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        int A, B;

        cin >> A >> B;

        Solution ob;
        vector<int> ans = ob.lcmAndGcd(A, B);
        cout << ans[0] << " " << ans[1] << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends
