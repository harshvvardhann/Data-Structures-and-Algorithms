package LinkedList.SinglyLinkedList;
class ReverseKNodes {
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
    public ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public ListNode findKthNode(ListNode temp, int k){
        k -= 1;
        while(temp!=null && k>0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode temp = head;

        while(temp!=null){
            ListNode kthNode = findKthNode(temp,k);
            if(kthNode == null){
                if(prev!=null){
                    prev.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            
            if(temp == head){
                head = kthNode;
            }else{
                prev.next = kthNode;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;   

    }
}