package LinkedList.SinglyLinkedList;

public class IntersectionOfLL {
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1!=temp2){
            temp1 = (temp1 == null)? headB : temp1.next;
            temp2 = (temp2 == null)? headA : temp2.next;
        }
        return temp1;
    }
}