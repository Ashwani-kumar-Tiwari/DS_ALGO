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

    Node head = null;
    Node tail = null;
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
        linkedLists merged = new  linkedLists();

        Node p1 = l1.head;
        Node p2 = l2.head;

        while(p1 != null && p2 != null){
            int val1 = p1.data;
            int val2 = p2.data;

            if(val1 < val2){
                merged.addLast(val1);
                p1 = p1.next;
            } else {
                merged.addLast(val2);
                p2 = p2.next;
            }
        }

        while(p1 != null){
            merged.addLast(p1.data);
            p1 = p1.next;
        }

        while(p2 != null){
            merged.addLast(p2.data);
            p2 = p2.next;
        }
        return merged;
    }

    public static Node getMidNode(Node lo, Node hi){
        Node slow = lo;
        Node fast = lo.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static linkedLists mergeSort(Node lo, Node hi){
        // write your code here
        if(lo == hi){
            linkedLists bres = new linkedLists();
            bres.addFirst(lo.data);
            return bres;
        }
        
        //step 1. get mid node and break the connection of middle
        Node mid = getMidNode(lo, hi);
        Node midNext = mid.next;
        mid.next = null;

        linkedLists l1 = mergeSort(lo, mid);
        linkedLists l2 = mergeSort(midNext, hi);

        linkedLists res = mergeTwoSortedLists(l1, l2);
        
        // step 2. make the connection of mid
        mid.next = midNext;
        return res;
      }

    public void removeDuplicates(){
        // write your code here
        Node prev = this.head;
        Node next = prev.next;

        while( next != null){
            if(prev.data == next.data){
                next = next.next;
            } else {
                prev.next = next;
                prev = next;
                next = next.next;
            }
        }

        prev.next = null;

        //set original head and tail
        this.tail = prev;
    }

    public void oddEven(){
        // write your code here
        Node ohead = new Node(); // odd ka head
        Node ehead = new Node();// even ka head

        Node t1 = ohead;
        Node t2 = ehead;

        Node i = this.head;

        while(i != null){
            if(i.data % 2 == 0){
                //even
                t2.next = i;
                t2 = i;
            } else {
                //odd
                t1.next = i;
                t1 = i;
            }
            i = i.next;
        }

        //odd -> even
        t1.next = ehead.next;
        t2.next = null;

        this.head = ohead.next;
        this.tail = t2 == ehead ? t1 :t2;
    }

    public void kReverse(int k) {
        // write your code here
        linkedLists prev = null;

        while(this.size() > 0){
            linkedLists curr = new linkedLists();
            if(this.size() >= k) {
                //remove first form list and add first in curr
                for(int i = 0; i < k; i++){
                    int data = this.getFirst();
                    this.removeFirst();
                    curr.addFirst(data);
                }
            } else {
                //remove first in list and add last in curr
                int sz = this.size();
                for(int i = 0; i < sz; i++){
                    int data = this.getFirst();
                    this.removeFirst();
                    curr.addLast(data);
                }
            }

            if(prev == null){
                prev = curr;
            } else{
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
                prev.size += curr.size;
            }
        }

        this.size = prev.size;
        this.head = prev.head;
        this.tail = prev.tail;
    }

    private void displayReverseHelper(Node node){
        // write your code here

        if(node == null) return;

        displayReverseHelper(node.next);
        System.out.print(node.data + " ");
    }
  
    public void displayReverse(){
        displayReverseHelper(head);
        System.out.println();
    }

    private void reversePRHelper(Node node){
        // write your code here
        if(node == null) return;

        reversePRHelper(node.next);

        if(node == tail){
            //nothing to add
        } else {
            node.next.next = node;
        }
      }
  
    public void reversePR(){
        // write your code here
        reversePRHelper(head);
        head.next = null;
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public static int addListHelper(Node one, int pv1, Node two, int pv2, linkedLists res){
        //pv -> place value
        //oc = old carry
        //nd = new data
        //nc = new carry

        if(one == null && two == null) return 0;

        int data = 0;
        if(pv1 > pv2){
            int oc = addListHelper(one.next, pv1 - 1, two, pv2, res);
            data = one.data + oc;
        } else if(pv1 < pv2){
            int oc = addListHelper(one, pv1, two.next, pv2 - 1, res);
            data = two.data + oc;
        } else {
            int oc = addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, res);
            data = one.data + two.data + oc;
        }
        int nd = data % 10;
        int nc = data / 10;

        res.addFirst(nd);
        return nc;
    }

    public static linkedLists addTwoLists(linkedLists one, linkedLists two) {
        // write your code here
        linkedLists res = new linkedLists();

        int oc = addListHelper(one.head, one.size, two.head, two.size, res);
        if(oc > 0){
            res.addFirst(oc);
        }
        return res;
    }

    public Node getMiddle(Node node){
        Node slow = node;
        Node fast = node.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node reverseNode(Node node){
        Node prev = null;
        Node curr = node;

        while(curr != null){
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    
    public boolean IsPalindrome() {
        // write your code here
        //1. get mid node
        Node mid = getMiddle(head);

        //2. make head2
        Node head2 = mid.next;
        mid.next = null;

        //3.revrse head2
        head2 = reverseNode(head2);

        //4.check for palindrome
        Node p1 = head;
        Node p2 = head2;

        boolean is_palindrome = true;

        while(p1 != null && p2 != null){
            if(p1.data != p2.data){
                is_palindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;

        }

        //5.maintain original list
        head2 = reverseNode(head2);
        mid.next = head2;

        return is_palindrome;
    }
    
    public void fold() {
        // write your code here
        if(head == null || head.next == null || head.next.next == null) return;
        //1. get mid node
        Node mid = getMiddle(head);

        //2. make head2
        Node head2 = mid.next;
        mid.next = null;

        //3.revrse head2
        head2 = reverseNode(head2);

        //4.make connection
        Node p1 = head;;
        Node p2 = head2;

        Node prev = head;
        while(p1 != null && p2 != null){
            Node n1 = p1.next;
            Node n2 = p2.next;
            p1.next = p2;
            p2.next = n1;
            p1 = n1;
            p2 = n2;

            if(p1 != null) prev = p1;
            if(p2 != null) prev = p2;
        } 

        //4. manage head and tail
        this.tail = prev;  
    }

    public static int findIntersection(linkedLists one, linkedLists two){
        // write your code here
        Node t1 = one.head;
        Node t2 = two.head;

        int delta = Math.abs(one.size - two.size);
        if(one.size > two.size){
            for(int i = 0; i < delta; i++){
                t1 = t1.next;
            }
        } else {
            for(int i = 0; i < delta; i++){
                t2 = t2.next;
            }
        }

        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1.data;
      }
}
      public class ques{
      public static void main(String[] args) throws Exception {
        linkedLists list1 = new  linkedLists();
        // linkedLists list2 = new  linkedLists();
        // linkedLists res = new  linkedLists();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        
        // list2.addLast(5);
        // list2.addLast(2);
        // list2.addLast(3);
        // list2.addLast(5);
        // list2.addLast(8);
        // list2.addLast(7);
        // System.out.println(list1.getFirst());
        // list.reverseDI(); //Reverse A Linked List (data Iterative)
        // list.reversePI(); //Reverse Linked List (pointer Iterative)
        // System.out.println(list.kthFromLast(3)); //Kth Node From End Of Linked List
        // System.out.println(list.mid1()); //Mid Of Linked List
        // System.out.println(list.mid2()); //Mid Of Linked List
        // res = linkedLists.mergeTwoSortedLists(list1, list2); //Merge Two Sorted Linked Lists
        // res = linkedLists.mergeSort(list1.head, list1.tail); //Merge Sort A Linked List
        // System.out.println(list2 + "\n" + list2.size());
        // System.out.println(res + "\n" + res.size());
        // list1.removeDuplicates(); // Remove Duplicates In A Linked List
        // list1.oddEven(); //Odd Even Linked List
        // list1.kReverse(3); // K Reverse In Linked List
        // list1.displayReverse(); //Display Reverse (recursive) - Linked List
        // list1.reversePR(); //Reverse Linked List (pointer - Recursive)
        // System.out.println(list2);
        // res = linkedLists.addTwoLists(list1, list2); //Add Two Linked Lists
        // System.out.println(res);
        // boolean res = list1.IsPalindrome(); //Is Linked List A Palindrome?
        list1.fold();//Fold A Linked List
        System.out.println(list1);
      }
}