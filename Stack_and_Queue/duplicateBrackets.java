// 1. You are given a string exp representing an expression.
// 2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
// 3. But, some of the pair of brackets maybe extra/needless. 
// 4. You are required to print true if you detect extra brackets and false otherwise.

// e.g.
// ((a + b) + (c + d)) -> false
// (a + b) + ((c + d)) -> true
import java.util.*;

public class duplicateBrackets{

    public static boolean isDuplicateBracketsPresent(String exp){
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == ' '){
                continue;
            } else if(ch == ')'){
                if(st.peek() == '('){
                    return true;
                } else {
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop(); // for opening brackets
                }
            } else {
                st.push(ch);
            }
        }

        return false;

    }

    public static void main(String[] args){
        String str = "((a + b) + (c + d))";
        boolean res = isDuplicateBracketsPresent(str);
        System.out.println(res);
    }
}