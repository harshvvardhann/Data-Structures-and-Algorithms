package LinkedList.SinglyLinkedList;
class Solution {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int digit1=(l1==null)?0:l1.data;
            int digit2=(l2==null)?0:l2.data;

            int sum=digit1+digit2+carry;
            carry=sum/10;

            ListNode temp=new ListNode(sum%10);
            tail.next=temp;
            tail=tail.next;

            l1=(l1==null)?null:l1.next;
            l2=(l2==null)?null:l2.next;
        }
        return dummy.next;
    }
}