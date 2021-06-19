import java.io.*;
import java.util.*;

public class questions {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
      }
    
      public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
          str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
    
        for (Node child : node.children) {
          display(child);
        }
      }
    
      public static Node construct(int[] arr) {
        Node root = null;
    
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == -1) {
            st.pop();
          } else {
            Node t = new Node();
            t.data = arr[i];
    
            if (st.size() > 0) {
              st.peek().children.add(t);
            } else {
              root = t;
            }
    
            st.push(t);
          }
        }
    
        return root;
      }
    
      public static int size(Node node){
        // write your code here
        int sz = 0;

        for (Node child : node.children) {
            sz += size(child);
        }

        return sz + 1;
      }

      public static int max(Node node) {
        // write your code here
        int mx = Integer.MIN_VALUE;

        for(Node child : node.children){
            mx = Math.max(mx, max(child));
        }

        return Math.max(mx, node.data);
      }

      public static int min(Node node) {
        // write your code here
        int mn = Integer.MAX_VALUE;

        for(Node child : node.children){
            mn = Math.min(mn, min(child));
        }

        return Math.min(mn, node.data);
      }

      public static int height(Node node) {
        // write your code here
        int ht = -1;//for edge basis, ht = 0, it is for node basis

        for(Node child : node.children){
            ht = Math.max(ht, height(child));
        }

        return ht + 1;
      }
      // msPair = multi solver pair
      public static class msPair {
        int min;
        int max;
        int ht;
        int size;

        public msPair(){
          this.min = Integer.MAX_VALUE;
          this.max = Integer.MIN_VALUE;
          this.ht = -1;
          this.size = 0;
        }
      }

      public static msPair multisolver(Node root){
        msPair mres = new msPair();//my result
        mres.min = mres.max = root.data;
        for(Node child : root.children){
          msPair rres = multisolver(child);//recursion result
          //min
          mres.min = Math.min(mres.min, rres.min);
          //max
          mres.max = Math.max(mres.max, rres.max);
          //height
          mres.ht = Math.max(mres.ht, rres.ht);
          //size
          mres.size += rres.size;
        }

        mres.ht += 1;
        mres.size += 1;
        return mres;
      }
    
      static int state = 0;
      static Node predecessor;
      static Node successor;
      public static void predecessorAndSuccessor(Node node, int data) {
        // write your code here
        if(state == 0){
          if(node.data == data){
            state++;
          } else {
            predecessor = node;
          }
        } else if(state == 1){
          successor = node;
          state++;
        } else {
          return;
        }

        for(Node child : node.children){
          if(state > 1) return;
          predecessorAndSuccessor(child, data);
        }
      }

      public static class IPair{
        Node node;
        int state;

        public IPair(Node node, int state){
          this.node = node;
          this.state = state;
        }
      }
      
      public static void IterativePreandPostOrder(Node root) {
        // write your code here
        Stack<IPair> st = new Stack<>();

        st.push(new IPair(root, -1));
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        while(st.size() > 0){
          IPair p = st.peek();
          if(p.state == -1){
            //pre area
            pre.add(p.node.data);
            p.state++;
          } else if(0 <= p.state && p.state < p.node.children.size()){
            // in area
            Node child = p.node.children.get(p.state);
            st.push(new IPair(child, -1));
            p.state++;
          } else {
            // post area
            post.add(p.node.data);
            st.pop();
          }
        }

        //print pre order
        for(int val : pre){
          System.out.print(val + " ");
        }
        System.out.println();

        //print post area
        for(int val : post){
          System.out.print(val + " ");
        }
        System.out.println();
      }
      
      public static void main(String[] args) throws Exception {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120
           -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
    
        Node root = construct(arr);
        // display(root);
        // int sz = size(root); // Size Of Generic Tree
        // int maximum = max(root); // Maximum In A Generic Tree
        // int minimum = min(root); // Minimum In A Generic Tree
        // int maxHeight = height(root); // Height Of A Generic Tree
        // msPair res = multisolver(root);
        // System.out.println("min :" + res.min);
        // System.out.println("max :" + res.max);
        // System.out.println("height :" + res.ht);
        // System.out.println("size :" + res.size);

        predecessorAndSuccessor(root, 40);
        System.out.println("succ " + successor.data);
        System.out.println("pre " + predecessor.data);
      }
}
