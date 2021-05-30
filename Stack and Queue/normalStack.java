class stack {
    private int[] arr;
    private int tos;

    public stack(int cap){
        this.arr = new int[cap];
        tos = 0;
    }

    public void push(int data){
        if(tos == arr.length){
            System.out.println("Stack overflow");
            return;
        }

        arr[tos] = data;
        tos++;
    }

    public int pop() {
        if(tos == 0){
            System.out.println("Stack underflow");
            return -1;
        }

        tos--;
        return arr[tos];
    }

    public int size() {
        return tos;
    }

    public int peek() {
        if(tos == 0){
            System.out.println("Stack underflow");
            return -1;
        }

        return arr[tos - 1];
    }

    public void display() {
        System.out.print("[");
        for(int i = 0; i < tos - 1; i++){
            System.out.print(arr[i] + ", ");
        }
        if(tos > 0){
            System.out.print(arr[tos - 1]);
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        String str = "[";
        for(int i = 0; i < tos - 1; i++){
            str += arr[i] + ", ";
        }
        if(tos > 0){
            str += arr[tos - 1];
        }

        str += "]";

        return str;
    }

}

public class normalStack {

    public static void demo(){
        stack st = new stack(5);

        st.display();
        System.out.println(st.peek());
        st.push(10);
        st.display();
        st.push(20);
        System.out.println(st.pop());
        st.display();
        st.push(30);
        System.out.println(st.size());
        System.out.println(st.peek());
        st.display();
        st.push(40);
        System.out.println(st.pop());
        st.display();
        st.push(50);
        System.out.println(st.peek());
        System.out.println(st);
        System.out.println(st.size());
    }
    public static void main(String[] args){
        demo();
    }
}
