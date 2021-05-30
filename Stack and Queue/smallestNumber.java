import java.util.*;

public class smallestNumber {
    
    public static void smallestNumberPattern(String pattern){
        Stack<Integer> st = new Stack<>();
        int count = 1;

        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);

            if(ch == 'd'){
                st.push(count);
                count++;
            } else {
                st.push(count);
                count++;
                //print stack
                while(st.size() > 0) {
                    System.out.print(st.pop());
                }
            }
        }
        st.push(count);
        count++;
        //print stack
        while(st.size() > 0) {
            System.out.print(st.pop());
        }
    }
    public static void main(String[] args){
        String pattern = "ddddiiii";
        smallestNumberPattern(pattern);
    }
}
