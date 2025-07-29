// Optimal

class Solution {
    // Function to flatten a linked list

  // Function to merge two sorted lists
    public Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        Node temp1 = list1;
        Node temp2 = list2;
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                temp.bottom = temp1;
                temp = temp1;
                temp1 = temp1.bottom;
            }
            else {
                temp.bottom = temp2;
                temp = temp2;
                temp2 = temp2.bottom;
            }
          // Additional Condition specific for this problem :-
          // This ensures that the horizontal links for the horizontal list (i.e topmost list) are disconnected
            temp.next = null;
        }
        temp.bottom = temp1 != null ? temp1 : temp2;
        return dummyNode.bottom;
    }
  // Recursive function which ensures that in each step 2 lists are merged and this formed list is further merged with another list and so on
    Node flatten(Node root) {
        // If head is null or there is no next node
        if (root == null || root.next == null) {
            return root;
        }
      // Recursively flatten the linked list
        Node rootToMerge = flatten(root.next);
      // Merge the 2 lists 
        return mergeTwoLists(root, rootToMerge);
    }
}
 
// T.C => O(n * (n1 + n2)) as for every recursive step (total n steps) we merge two lists which takes O(n1 + n2) where n1 and n2 are size of the two vertical sublists being merged
// S.C => O(n) for the recursion stack (n is the size of the horizontal list)
