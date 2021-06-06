import java.util.Stack;

public class celebrity {

    public static void celebrityProblem(int[][] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i = 0; i < n; i++){
            st.push(i);
        }

        while(st.size() > 1){
            int i = st.pop();
            int j = st.pop();

            if(arr[i][j] == 1){
                // i knows j, it means i is not celebrity
                st.push(j);
            } else {
                // i don't know j,  it means j is not celebrity
                st.push(i);
            }
        }

        int candidate = st.pop(); // potential candidate for celebrity

        //check within row, arr[candidate][c] == 0
        for(int c = 0; c < n; c++){
            if(arr[candidate][c] == 1){
                System.out.println("none");
                return;
            }
        }

        //check within column, arr[r][candidate] == 1, except for arr[candidate][candidate] == 0
        for(int r = 0; r < n; r++){
            if(r != candidate && arr[r][candidate] == 0){
                System.out.println("none");
                return;
            }
        }

        System.out.println(candidate);
    }
    
    public static void main(String[] args){
        int[][] arr =
        {
            {0,0,0,0},
            {1,0,1,1},
            {1,1,0,1},
            {1,1,1,0}
        };

        celebrityProblem(arr);
    }
}
