    class deque {
        private int[] data;
        private int front = 0;
        private int size = 0;
    
        public deque(int cap){
            data = new int[cap];
        }
    
        public void add(int val){
            if(size == data.length){
                int[] ndata = new int[2 * data.length];
            
                for(int i = 0; i < size; i++){
                    int indx = (front + i) % data.length;
                    ndata[i] = data[indx];
                }
                ndata[size] = val;
                size++;
                front = 0;
                data = ndata;
            } else {
                int indx = (front + size) % data.length;
                data[indx] = val;
                size++;
            }
        }
    
        public int remove(){
            if(size == 0){
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }
    
        public int size() {
            return size;
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
    
        public int peek() {
            if(size == 0){
                System.out.println("Queue underflow");
                return -1;
            } else {
                return data[front];
            }
        }
    
        @Override
        public String toString() {
            String str = "[";
    
            for(int i = 0; i < size -1; i++){
                int indx = (front + i) % data.length;
                str += data[indx] + ", ";
            }
    
            if(size > 0){
                int indx = (front + size - 1) % data.length;
                str += data[indx];
            }
    
            str += "]";
    
            return str;
        }
    }
    
    public class myDeque {
        
        public static void demo(){
            deque qu = new deque(6);
    
            qu.add(10);
            qu.add(20);
            qu.add(30);
            System.out.println(qu.size());
            qu.add(40);
            qu.add(50);
            qu.add(60);
            qu.add(70);
            System.out.println(qu.remove());
            System.out.println(qu.remove());
            System.out.println(qu.peek());
            qu.add(80);
            System.out.println(qu.peek());
            qu.add(90);
            System.out.println(qu);
            System.out.println(qu.remove());
            qu.add(100);
            qu.add(110);
            System.out.println(qu.remove());
            System.out.println(qu.remove());
            System.out.println(qu.peek());
            System.out.println(qu.remove());
            System.out.println(qu.remove());
            System.out.println(qu.remove());
            System.out.println(qu.remove());
            System.out.println(qu.peek());
        }

        public static void main(String[] args){
            demo();
        }
}
