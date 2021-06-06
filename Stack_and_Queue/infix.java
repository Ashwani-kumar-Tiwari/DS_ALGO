import java.util.*;

public class infix {

    //priority
    public static int priority(char op){
        if(op == '*' || op == '/'){
            return 2;
        } else if (op == '+' || op == '-'){
            return 1;
        } else {
            return 0;
        }
    }

    //evaluate
    public static int evaluate(int val1, int val2, char op){
        if(op == '*'){
            return val1 * val2;
        } else if(op == '/'){
            return val1 / val2;
        } else if(op == '+'){
            return val1 + val2;
        } else if(op == '-'){
            return val1 - val2;
        } else {
            return 0;
        }
    }

    //infix
    public static void infixEvaluation(String exp){
        Stack<Character> ostack = new Stack<>(); // operater stack
        Stack<Integer> vstack = new Stack<>(); // value stack

        for(int i = 0; i< exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == ' '){
                continue;
            } else if(ch >= '0' && ch <= '9'){
                vstack.push((int)(ch - '0'));
            } else if( ch == '('){
                ostack.push(ch);
            } else if(ch == ')') {
                while(ostack.peek() != '('){
                    char op = ostack.pop();
                    int val2 = vstack.pop();
                    int val1 = vstack.pop();

                    int res = evaluate(val1, val2, op);
                    vstack.push(res);
                }
                ostack.pop(); // this pop is for opening bracket
            } else {
                while(ostack.size() > 0 && ostack.peek() != '(' && priority(ostack.peek()) >= priority(ch)){
                    //process
                    char op = ostack.pop();
                    int val2 = vstack.pop();
                    int val1 = vstack.pop();

                    int res = evaluate(val1, val2, op);
                    vstack.push(res);
                }
                ostack.push(ch);
            }
        }

        while(ostack.size() > 0){
            char op = ostack.pop();
            int val2 = vstack.pop();
            int val1 = vstack.pop();

            int res = evaluate(val1, val2, op);
            vstack.push(res);
        }


        System.out.println(vstack.peek());
    }

    public static void infixToPrefix(String exp){
        Stack<Character> ostack = new Stack<>(); // operater stack
        Stack<String> vstack = new Stack<>(); // value stack

        for(int i = 0; i< exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == ' '){
                continue;
            } else if(ch >= '0' && ch <= '9'){
                vstack.push(("" + ch));
            } else if( ch == '('){
                ostack.push(ch);
            } else if(ch == ')') {
                while(ostack.peek() != '('){
                    char op = ostack.pop();
                    String val2 = vstack.pop();
                    String val1 = vstack.pop();

                    String res = op + val1 + val2;
                    vstack.push(res);
                }
                ostack.pop(); // this pop is for opening bracket
            } else {
                while(ostack.size() > 0 && ostack.peek() != '(' && priority(ostack.peek()) >= priority(ch)){
                    //process
                    char op = ostack.pop();
                    String val2 = vstack.pop();
                    String val1 = vstack.pop();

                    String res = op + val1 + val2;
                    vstack.push(res);
                }
                ostack.push(ch);
            }
        }

        while(ostack.size() > 0){
            char op = ostack.pop();
            String val2 = vstack.pop();
            String val1 = vstack.pop();

            String res = op + val1 + val2;
            vstack.push(res);
        }

        System.out.println(vstack.peek());

    }

    public static void infixToPostfix(String exp){
        Stack<Character> ostack = new Stack<>(); // operater stack
        Stack<String> vstack = new Stack<>(); // value stack

        for(int i = 0; i< exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == ' '){
                continue;
            } else if(ch >= '0' && ch <= '9'){
                vstack.push(("" + ch));
            } else if( ch == '('){
                ostack.push(ch);
            } else if(ch == ')') {
                while(ostack.peek() != '('){
                    char op = ostack.pop();
                    String val2 = vstack.pop();
                    String val1 = vstack.pop();

                    String res = val1 + val2 + op;
                    vstack.push(res);
                }
                ostack.pop(); // this pop is for opening bracket
            } else {
                while(ostack.size() > 0 && ostack.peek() != '(' && priority(ostack.peek()) >= priority(ch)){
                    //process
                    char op = ostack.pop();
                    String val2 = vstack.pop();
                    String val1 = vstack.pop();

                    String res = val1 + val2 + op;
                    vstack.push(res);
                }
                ostack.push(ch);
            }
        }

        while(ostack.size() > 0){
            char op = ostack.pop();
            String val2 = vstack.pop();
            String val1 = vstack.pop();

            String res = val1 + val2 + op;
            vstack.push(res);
        }

        System.out.println(vstack.peek());
    }

    public static void main(String[] args){
        String exp = "2+(6*4)/8-3";
        infixEvaluation(exp);
        infixToPostfix(exp);
        infixToPrefix(exp);

    }
    
}
