// 1. You are given a string exp representing an expression.
// 2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

// e.g.
// [(a + b) + {(c + d) * (e / f)}] -> true
// [(a + b) + {(c + d) * (e / f)]} -> false
// [(a + b) + {(c + d) * (e / f)} -> false
// ([(a + b) + {(c + d) * (e / f)}] -> false

import java.util.*;
public class balancedBrackets {
    
    //Method 1
    public static boolean isBracketsBalanced1(String exp){
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == ' ' || ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                continue;
            } else if(ch == ')'){
                if(st.size() == 0){
                    return false;
                } else {
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop(); // for opening brackets
                }
            } else if(ch == '}'){
                if(st.size() == 0){
                    return false;
                } else {
                    while(st.peek() != '{'){
                        st.pop();
                    }
                    st.pop(); // for opening brackets
                }
            } else if(ch == ']'){
                if(st.size() == 0){
                    return false;
                } else {
                    while(st.peek() != '['){
                        st.pop();
                    }
                    st.pop(); // for opening brackets
                }
            } else {
                st.push(ch);
            }
        }

        if(st.size() > 0){
            return false;
        } else {
            return true;
        }
    }

    //Method 2
    public static boolean isBracketsBalanced2(String exp){
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            } else if(ch == ')'){
                if(st.size() == 0 || st.peek() != '(')
                    return false;
                st.pop();
            } else if(ch == '}'){
                if(st.size() == 0 || st.peek() != '{')
                    return false;
                st.pop();
            } else if(ch == ']'){
                if(st.size() == 0 || st.peek() != '[')
                    return false;
                st.pop();
            }
        }

        return st.size() == 0;
    }

    public static void main(String[] args){
        String str = "(a + b) + {c + d} + [e + f]";
        boolean res1 = isBracketsBalanced1(str);
        boolean res2 = isBracketsBalanced2(str);
        System.out.println(res1);
        System.out.println(res2);
    }
}
