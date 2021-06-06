import java.util.Stack;

public class postfix {
    
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
    
    // //postfix
    public static void postfixEvaluation(String exp){
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch >= '0' && ch <= '9'){
                st.push((int)(ch - '0'));
            } else {
                int val2 = st.pop();
                int val1 = st.pop();

                int res = evaluate(val1, val2, ch);
                st.push(res);
            }
        }
        System.out.println(st.peek());
    }

    public static void postfixToInfix(String exp){
        Stack<String> st = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch >= '0' && ch <= '9'){
                st.push("" + ch);
            } else {
                String val2 = st.pop();
                String val1 = st.pop();

                String res = "(" + val1 + ch + val2 + ")";
                st.push(res);
            }
        }
        System.out.println(st.peek());
    }

    public static void postfixToPrefix(String exp){
        Stack<String> st = new Stack<>();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch >= '0' && ch <= '9'){
                st.push("" + ch);
            } else {
                String val2 = st.pop();
                String val1 = st.pop();

                String res = ch + val1 + val2;
                st.push(res);
            }
        }
        System.out.println(st.peek());
    }

    public static void main(String[] args){
        String exp = "264*8/+3-";
        postfixEvaluation(exp);
        postfixToInfix(exp);
        postfixToPrefix(exp);

    }
}
