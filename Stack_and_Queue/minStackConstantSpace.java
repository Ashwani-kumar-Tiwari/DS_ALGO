import java.io.*;
import java.util.*;

public class minStackConstantSpace {
    

  public static class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
      st = new Stack<>();
    }

    int size() {
      return st.size();
    }

    void push(int val) {
        if(st.size() == 0){
            st.push(val);
            min = val;
            return;
        }
        if(val > min){
            st.push(val);
        } else {
            st.push(2 * val - min);
            min = val;
        }
    }

    int pop() {
        if(st.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }

        int data = 0;
        if(st.peek() > min){
            data = st.pop();
        } else {
            data = min;
            min = 2 * min - st.pop();
        }

        return data;
    }

    int top() {
        if(st.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        if(st.peek() > min){
            return st.peek();
        } else {
            return min;
        }
    }

    int min() {
        if(st.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}
