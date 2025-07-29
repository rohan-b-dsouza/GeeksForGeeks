// Brute

class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        Node temp = root;
        List<Integer> list = new ArrayList<>();
        // Store the data of all the nodes in a list
        while (temp != null) {
            Node temp1 = temp;
            while (temp1 != null) {
                list.add(temp1.data);
                temp1 = temp1.bottom;
            }
            temp = temp.next;
        }
        // Sort the list
        list.sort(null);
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        // Create a new LL using this sorted list
        for (int num : list) {
            curr.bottom = new Node(num);
            curr = curr.bottom;
        }
        // Return the new LL
        return dummyNode.bottom;
        
    }
}

// T.C => O(n * m) + O(n * m) where n stands for no. of nodes in horizontal list  and m stands for no. of nodes in vertical sub-lists
// S.C => O(n * m) for the extra list
