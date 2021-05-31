import java.util.*;

class linkedlist{
    private class Node{
        private int data;
        private Node next;

        public Node(){
            this.data = 0;
            this.next = null;
        }

        public Node(int data){
            this.data = data;
            this.next = null;
        }

        public Node(Node next, int data){
            this.next = next;
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private void handleAddWhenSize0(int data){
        Node nn = new Node(data);
        head = tail = nn;
        size = 1;
    }
    
    public void addFirst(int data){
        if(size == 0){
            handleAddWhenSize0(data);
        } else {
            Node nn = new Node(data); // memory allocation
            nn.next = head; // connection
            head = nn;
            size++;
        }
    }

    public void addLast(int data){
        if(size == 0){
            handleAddWhenSize0(data);
        } else {
            Node nn = new Node(data); // memory allocation
            tail.next = nn; // connection
            tail = nn;
            size++;
        }
    }

    private Node getNodeAt(int pos){
        Node temp = this.head;
        while(pos > 0){
            temp = temp.next;
            pos--;
        }

        return temp;
    }

    public void addAt(int data, int indx){
        if(indx < 0 || indx > size){
            System.out.println("Invalid Index");
            return;
        } else if(indx == 0){
            addFirst(data);
        } else if(indx == size){
            addLast(data);
        } else {
            Node nm1 = getNodeAt(indx-1);
            Node nn = new Node(data); // memory allocation
            nn.next = nm1.next; // connection
            nm1.next = nn;
            size++;
        }
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked List underflow");
            return -1;
        } else if(size == 1){
            head = tail = null;
            size = 0;
            return head.data;
        } else{
            int temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("Linked List underflow");
            return -1;
        } else if(size == 1){
            head = tail = null;
            size = 0;
            return head.data;
        }else {
            int temp = tail.data;
            Node newTail = getNodeAt(size - 2);
            newTail.next = null;
            size--;
            return temp;
        }
    }

    public int removeAt(int indx){
        if(indx < 0 || indx > size){
            System.out.println("Invalid Index");
            return -1;
        } else if(indx == 0){
            return removeFirst();
        } else if(indx == size){
            return removeLast();
        } else {
            Node nn = getNodeAt(indx);
            Node nm1 = getNodeAt(indx-1);
            Node nm2 = getNodeAt(indx+1);
            nm1.next = nm2; // connection
            size--;

            return nn.data;
        }
    }

    public int getFirst(){
        if(size == 0){
            System.out.println("underflow");
            return -1;
        } else {
            return head.data;
        }
    }

    public int getLast(){
        if(size == 0){
            System.out.println("underflow");
            return -1;
        } else {
            return tail.data;
        }
    }

    public int getAt(int indx){
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else if (indx < 0 || indx >= size) {
            System.out.println("Invalid arguments");
            return -1;
          } else {
            Node temp = head;
            for (int i = 0; i < indx; i++) {
              temp = temp.next;
            }
            return temp.data;
          }
        }
    }

    public int size(){
        return size;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    @Override
    public String toString(){
        String str = "";

        Node temp = head;
        while(temp != null){
            str += temp.data + " -> ";
            temp = temp.next;
        }
        str += "null";

        return str;
    }

}
public class myLinkedList{

    public static void demo(){
        linkedlist list = new  linkedlist();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        System.out.println(list + "\n" + list.size());
        list.addAt(35, 3);
        System.out.println(list + "\n" + list.size());
        System.out.println(list.removeFirst());
        System.out.println(list + "\n" + list.size());
        System.out.println(list.removeLast());
        System.out.println(list + "\n" + list.size());

        //list.display();
    }
    public static void main(String[] args) {
        demo();
    }
}