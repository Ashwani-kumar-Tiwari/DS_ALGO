import java.util.Stack;

public class prefix {
   
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
    
    // //prefix
    public static void prefixEvaluation(String exp){
        Stack<Integer> st = new Stack<>();

        for(int i = exp.length() - 1; i >= 0; i--){
            char ch = exp.charAt(i);

            if(ch >= '0' && ch <= '9'){
                st.push((int)(ch - '0'));
            } else {
                int val1 = st.pop();
                int val2 = st.pop();

                int res = evaluate(val1, val2, ch);
                st.push(res);
            }
        }
        System.out.println(st.peek());
    }

    public static void PrefixToInfix(String exp){
        Stack<String> st = new Stack<>();

        for(int i = exp.length() - 1; i >= 0; i--){
            char ch = exp.charAt(i);

            if(ch >= '0' && ch <= '9'){
                st.push("" + ch);
            } else {
                String val1 = st.pop();
                String val2 = st.pop();

                String res = "(" + val1 + ch + val2 + ")";
                st.push(res);
            }
        }
        System.out.println(st.peek());
    }

    public static void prefixToPostfix(String exp){
        Stack<String> st = new Stack<>();

        for(int i = exp.length() - 1; i >= 0; i--){
            char ch = exp.charAt(i);

            if(ch >= '0' && ch <= '9'){
                st.push("" + ch);
            } else {
                String val1 = st.pop();
                String val2 = st.pop();

                String res = val1 + val2 + ch;
                st.push(res);
            }
        }
        System.out.println(st.peek());
    }

    public static void main(String[] args){
        String exp = "-+2/*6483";
        prefixEvaluation(exp);
        PrefixToInfix(exp);
        prefixToPostfix(exp);

    }
}
