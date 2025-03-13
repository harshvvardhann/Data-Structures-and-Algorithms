package LinkedList.DoublyLinkedList;

public class reverse {
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node reverse2(Node head){
        Node current = head;
        Node temp = null;

        while(current!=null){
            temp = current.prev;//null//1
            current.prev = current.next;//1 previous 2
            current.next = temp;//1 next null
            current = current.prev;//current 2
        }

        if(temp!=null){
            head = temp.prev;
        }   
        return head;
    }
}

// 1->2->3->4->5
