package LinkedList.SinglyLinkedList;
class RemoveNthNodeFromEnd {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null && n == 1) return null;
        int count = 0;
        ListNode countNodes = head;
        while(countNodes!=null){
            count++;
            countNodes = countNodes.next;
        }
        if(count<n) return null;

        int deletionNode = count - n;
        if(deletionNode == 0) {
            head = head.next;
            return head;
        }
        int x = 0;
        ListNode temp = head;
        while(temp!=null){
            x++;
            if(x == deletionNode){
                if(temp.next.next != null) temp.next = temp.next.next;
                else temp.next = null;
            }
            temp = temp.next;
        }
        return head;
    }
}