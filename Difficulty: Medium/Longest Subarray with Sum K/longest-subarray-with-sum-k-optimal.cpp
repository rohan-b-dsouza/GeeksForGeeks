//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// Note :- This gfg qn constraints specify that elements can be positives, negatives, zeroes.
// This is a Better Solution when only positives and zeros occur, but Optimal Solution when positives,negatives,zeroes occur.

class Solution {
  public:
    int longestSubarray(vector<int>& arr, int k) {
        int n = arr.size();
        int maxlen = 0;
        int sum = 0;
        int len = 0;
        unordered_map <int, int> prefixSum;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int rem = sum - k;
            if (sum == k) {
                maxlen = max(maxlen, i + 1);
            }
            if (prefixSum.find(rem) != prefixSum.end()) {
                len = i - prefixSum[rem];
                maxlen = max(maxlen, len);
            }
            if (prefixSum.find(sum) == prefixSum.end()) {
                prefixSum[sum] = i;
            }
        }
        return maxlen;
    }
};

// T.C => O(n)
// S.C => O(n) for extra unordered map used

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore(); // Ignore newline character after t

    while (t--) {
        vector<int> arr;
        int k;
        string inputLine;

        getline(cin, inputLine); // Read the array input as a line
        stringstream ss(inputLine);
        int value;
        while (ss >> value) {
            arr.push_back(value);
        }

        cin >> k;
        cin.ignore(); // Ignore newline character after k input

        Solution solution;
        cout << solution.longestSubarray(arr, k) << "\n";
        cout << "~\n";
    }

    return 0;
}

// } Driver Code Ends
