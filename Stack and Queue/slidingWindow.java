// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing the elements of array a.
// 3. You are given a number k, representing the size of window.
// 4. You are required to find and print the maximum element in every window of size k.

// e.g.
// the array is [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] 
// for k = 4, 
// the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]

import java.util.Stack;

public class slidingWindow {
    
    //my solution
    // public static void slidingWindowMaximum(int[] arr, int k){
    //     int[] res = new int[arr.length - 3];
    //     int max = Integer.MIN_VALUE;

    //     for(int i = 0; i< arr.length - 3; i++){
    //         for(int j = i; j < k + i; j++){
    //             if(arr[j] > max){
    //                 max = arr[j];
    //             }
    //         }
    //         res[i] = max;
    //         max = Integer.MIN_VALUE;
    //     }

    //     for(int i = 0; i < res.length; i++){
    //         System.out.print(res[i] + " ");
    //     }
    // }

    public static int[] ngiForSlidingWindow(int[] arr){
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] res = new int[arr.length];
        for(int i = 1; i < arr.length; i++){
            while(st.size() > 0 && arr[st.peek()] < arr[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }

        while(st.size() > 0){
            res[st.pop()] = arr.length;
        }

        return res;
    }

    public static void slidingWindowMaximum(int[] arr, int k){
        int[] ngri = ngiForSlidingWindow(arr);

        int j = 0;
        for(int i = 0; i <= arr.length - k; i++){
            if(j < i){
                j = i;
            }
            while(i + k > ngri[j]){
                j = ngri[j];
            }
            System.out.println(arr[j]);
        }
    }

    public static void main(String[] args){
        int[] arr = {2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6};
        int k = 4;
        slidingWindowMaximum(arr, k);
    }
}
