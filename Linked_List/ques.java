class linkedLists{
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

    public void reverseDI() {
        // write your code here
        int left = 0;
        int right = this.size - 1;

        while(left < right){
            Node lnode = getNodeAt(left);
            Node rnode = getNodeAt(right);

            //data swaping
            int temp = lnode.data;
            lnode.data = rnode.data;
            rnode.data = temp;

            left++;
            right--;
        }
    }

    public void reversePI() {
        // write your code here
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // swapping of head and tail pointer
        Node temp = head;
        head = tail;
        tail = temp; 
    }

    public int kthFromLast(int k){
        // write your code here
        Node slow = head;
        Node fast = head;
        
        //1. move fask at k step away from head
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }
        
        //2. move slow and fast simultaneously until fast.next != null
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow.data;
    }

    public int mid1(){
        // write your code here
        if(head == null) return -1;

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next; // speed x
            fast = fast.next.next;// speed 2x
        }

        return slow.data;
    }

    public int mid2(){
        // write your code here
        if(head == null) return -1;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; // speed x
            fast = fast.next.next;// speed 2x
        }

        return slow.data;
    }

    public static linkedLists mergeTwoSortedLists(linkedLists l1, linkedLists l2) {
        // write your code hered
        linkedLists res = new  linkedLists();

        Node p1 = l1.head;
        Node p2 = l2.head;

        while(p1 != null && p2 != null){
            int val1 = p1.data;
            int val2 = p2.data;

            if(val1 < val2){
                res.addLast(val1);
                p1 = p1.next;
            } else {
                res.addLast(val2);
                p2 = p2.next;
            }
        }

        while(p1 != null){
            p1.addLast(p1.data);
            p1 = p1.next;
        }

        while(p2 != null){
            p2.addLast(p2.data);
            p2 = p2.next;
        }
        return res;
    }
}
      public class ques{
      public static void main(String[] args) throws Exception {
        linkedLists list1 = new  linkedLists();
        linkedLists list2 = new  linkedLists();
        list1.addLast(10);
        list1.addLast(20);
        list1.addLast(30);
        list1.addLast(40);
        list1.addLast(50);
        list1.addLast(60);
        list1.addLast(70);
        
        list2.addLast(15);
        list2.addLast(25);
        list2.addLast(35);
        list2.addLast(45);
        list2.addLast(55);
        list2.addLast(65);
        list2.addLast(75);
        // System.out.println(list + "\n" + list.size());
        // list.reverseDI(); //Reverse A Linked List (data Iterative)
        // list.reversePI(); //Reverse Linked List (pointer Iterative)
        // System.out.println(list.kthFromLast(3)); //Kth Node From End Of Linked List
        // System.out.println(list.mid1()); //Mid Of Linked List
        // System.out.println(list.mid2()); //Mid Of Linked List
        linkedLists res = mergeTwoSortedLists(list1, list2);
        System.out.println(list1 + "\n" + list1.size());
        System.out.println(list2 + "\n" + list2.size());
        System.out.println(res + "\n" + res.size());
      }
}