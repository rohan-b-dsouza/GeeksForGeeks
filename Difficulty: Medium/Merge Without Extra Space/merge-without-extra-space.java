//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    // Function to merge the arrays.
    static void swapIfGreater(int a[], int b[], int left, int right) {
        if (a[left] > b[right]) {
            int temp = a[left];
            a[left] = b[right];
            b[right] = temp;
        }
    }
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;
        int len = n + m;
        int gap = (len / 2) + len % 2;
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
               if (left < n && right >= n) {
                swapIfGreater(a, b, left, right - n);
                }
                else if (left >= n && right > n) {
                    swapIfGreater(b, b, left - n, right - n);
                }
                else {
                    swapIfGreater(a, a, left, right);
                } 
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + gap % 2;
        }
        
    }
}
