package LinkedList.DoublyLinkedList;
class SolutDeleteNodeAtPositionion {
    class Node {
        int data;
        Node next;
        Node prev;
    
        Node(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }
    public Node deleteNode(Node head, int x) {
        // code here
        if(x == 1){
            head = head.next;
            head.prev = null;
            return head;
        }
        
        int count = 1;
        Node temp = head;
        while(temp!=null){
            if(count == x){
                if(temp.next == null){
                    temp.prev.next = null;
                }else{
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
            }
            temp = temp.next;
            count++;
        }
        return head;
    }
}