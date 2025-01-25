s//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    // Optimal - Approach
    int getSecondLargest(vector<int> &arr) {
        int n = arr.size();
        int max = arr[0];
        int smax = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                smax = max;
                max = arr[i];
            }
            if (arr[i] > smax && arr[i] != max) {
                smax = arr[i];
            }
        }
        return smax;
    }
};
// T.C => O(n)
// S.C => O(1)
//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        Solution ob;
        int ans = ob.getSecondLargest(arr);
        cout << ans << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends
