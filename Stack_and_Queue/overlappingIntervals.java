import java.util.*;

public class overlappingIntervals {
    
    public static class Pair implements Comparable<Pair> {
        int st;
        int end;

        public Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }

        public int compareTo(Pair other) {
            return this.st - other.st;
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        
        Pair[] pairs = new Pair[arr.length];

        for(int i = 0; i < pairs.length; i++) {
            int st = arr[i][0];
            int end = arr[i][1];

            pairs[i] = new Pair(st, end);
        }
    
        Arrays.sort(pairs);
        // stack

        Pair res = pairs[0];
        for(int i = 1; i < pairs.length; i++) {
            Pair p = pairs[i];
            if(res.end >= p.st) {
                if(res.end < p.end) {
                    res.end = p.end;
                }
            } else {
                System.out.println(res.st + " " + res.end);
                res =  p;
            }
        }
        System.out.println(res.st + " " + res.end);


        // Stack<Pair> st = new Stack<>();
        // st.push(pairs[0]);

        // for(int i = 1; i < pairs.length; i++) {
        //     Pair p = pairs[i];
        //     if(st.peek().end >= p.st) {
        //         if(st.peek().end < p.end) {
        //             st.peek().end = p.end;
        //         }
        //     } else {
        //         st.push(p);
        //     }
        // }

        // Stack<Pair> st2 = new Stack<>();
        // while(st.size() > 0)
        //     st2.push(st.pop());
            
        // // print intervals
        // while(st2.size() > 0) {
        //     Pair rem = st2.pop();
        //     System.out.println(rem.st + " " + rem.end);
        // }
    }

    public static void main(String[] args){
        int[][] arr =
        {
            {22,28},
            {1,8},
            {25,27},
            {14,19},
            {27,30},
            {5,12}
        };

        mergeOverlappingIntervals(arr);
    }
}
