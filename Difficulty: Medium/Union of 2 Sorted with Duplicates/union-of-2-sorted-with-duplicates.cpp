//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // a,b : the arrays
    // Function to return a list containing the union of the two arrays.
    vector<int> findUnion(vector<int> &a, vector<int> &b) {
       set <int> st;
       for (int i = 0; i < a.size(); i++) {
           st.insert(a[i]);
       }
       for (int j = 0; j < b.size(); j++) {
           st.insert(b[j]);
       }
       vector <int> v;
       for (auto it: st) {
           v.push_back(it);
       }
       return v;
    }
};

// T.C => O(n1log(n) + o(n2log(n)) + O(n1 + n2) ................{ n1 stands for elements in array 1 and n2 for array 2 whereas n is the number of elements in the set which varies in each step}
// S.C => O(n1 + n2) + O(n1 + n2) .............{for extra set and extra vector, Note :- The extra vector is not required to solve the problem but to return the answer}


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> a, b;
        string input;

        // Read first array
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            a.push_back(number);
        }

        // Read second array
        getline(cin, input);
        stringstream ss2(input);
        while (ss2 >> number) {
            b.push_back(number);
        }

        Solution ob;
        vector<int> ans = ob.findUnion(a, b);
        for (int i : ans)
            cout << i << ' ';
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends
