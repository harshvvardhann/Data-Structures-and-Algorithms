package LinkedList.SinglyLinkedList;

public class reverse {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node reverse2(Node head){
        Node current = head;
        Node prev = null;
        Node next = null;   

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}

// 1->2->3->4->5
