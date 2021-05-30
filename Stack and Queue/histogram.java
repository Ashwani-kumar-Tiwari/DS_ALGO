import java.io.*;
import java.util.*;

public class histogram{

    public static int[] nslIndex(int[] arr) {
        Stack<Integer> st = new Stack<>();

        st.push(arr.length - 1);
        int[] res = new int[arr.length];
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] > arr[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while (st.size() > 0) {
            res[st.pop()] = -1;
        }
        return res;
    }

    public static int[] nsrIndex(int[] arr) {
        Stack<Integer> st = new Stack<>();

        st.push(0);
        int[] res = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] > arr[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        while (st.size() > 0) {
            res[st.pop()] = arr.length;
        }
        return res;
    }

    public static int largestAreaHistogram(int[] arr) {
        int[] lsi = nslIndex(arr);
        int[] rsi = nsrIndex(arr);

        int area = 0;

        for (int i = 0; i < arr.length; i++) {
            int width = rsi[i] - lsi[i] - 1;
            int ht = arr[i];
            area = Math.max(area, width * ht);
        }
        return area;
    }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    // code
    int res = largestAreaHistogram(a);
    System.out.println(res);
 }
}