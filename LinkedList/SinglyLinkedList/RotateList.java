package LinkedList.SinglyLinkedList;
class RotateList {
    class ListNode {
        int data;
        ListNode next;
        ListNode prev;
    
        ListNode(int val) {
            data = val;
            next = null;
            prev = null;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        int count = 1;
        if(head == null || k==0) return head;
        ListNode temp = head;
        while(temp.next!=null){
            count++;
            temp = temp.next;
        }

        if(k%count == 0) return head;
        temp.next = head;

        ListNode current = head;
        k = k % count;
        int x = 1;
        while(current.next!=null && x!=(count-k)){
            current = current.next;
            x++;
        }
        head = current.next;
        current.next = null;

        return head;
    }
}