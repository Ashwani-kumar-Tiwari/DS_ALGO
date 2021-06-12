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
        int s = 0;

        for (Node child : node.children) {
        s += size(child);
        }
        s += 1;

        return s;
      }
    
      public static void main(String[] args) throws Exception {
        int[] arr = {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};
    
        Node root = construct(arr);
        int sz = size(root); //Size Of Generic Tree
        System.out.println(sz);
        display(root);
      }
}
