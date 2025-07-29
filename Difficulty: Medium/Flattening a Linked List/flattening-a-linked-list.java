class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        Node temp = root;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            Node temp1 = temp;
            while (temp1 != null) {
                list.add(temp1.data);
                temp1 = temp1.bottom;
            }
            temp = temp.next;
        }
        list.sort(null);
        Node dummyNode = new Node(-1);
        Node curr = dummyNode;
        for (int num : list) {
            curr.bottom = new Node(num);
            curr = curr.bottom;
        }
        return dummyNode.bottom;
        
    }
}