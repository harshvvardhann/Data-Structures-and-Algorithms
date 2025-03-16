package LinkedList.SinglyLinkedList;
class SortLinkedList {
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
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode newNode = new ListNode(-1);
        ListNode current = newNode;

        while(left != null && right != null){
            if(left.data < right.data){
                current.next = left;
                current = left;
                left = left.next;
            }else{
                current.next = right;
                current = right;
                right = right.next;
            }
        }

        if(left != null) current.next = left;
        else current.next = right;

        return newNode.next;

    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode midNode = findMiddle(head);
        ListNode right = midNode.next;
        midNode.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return merge(left,right);
    }
}