import java.io.*;
import java.util.*;

public class minStack1 {

    public static class MinStack {
        Stack<Integer> st;
        Stack<Integer> minSt;

        public MinStack() {
            st = new Stack<>();
            minSt = new Stack<>();
        }

        int size() {
            return st.size();
        }

        void push(int val){
            st.push(val);
            if(minSt.size() == 0){
                minSt.push(val);
            } else {
                minSt.push(Math.min(minSt.peek(), val));
            }
        }

        int pop() {
            if(st.size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }

            int val = st.peek();
            st.pop();
            minSt.pop();
            return val;
        }

        int top() {
            if(st.size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }
            return st.peek();
        }

        int min(){
            if(st.size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }
            return minSt.peek();
        }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      } else if(str.startsWith("min")){
        int val = st.min();
        if(val != -1){
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}
