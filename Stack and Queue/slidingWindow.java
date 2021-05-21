// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing the elements of array a.
// 3. You are given a number k, representing the size of window.
// 4. You are required to find and print the maximum element in every window of size k.

// e.g.
// the array is [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] 
// for k = 4, 
// the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]

public class slidingWindow {
    

    public static void slidingWindowMaximum(int[] arr){
        int[] res = new int[arr.length - 3];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i< arr.length - 3; i++){
            for(int j = i; j < 4 + i; j++){
                if(arr[j] > max){
                    max = arr[j];
                }
            }
            res[i] = max;
            max = Integer.MIN_VALUE;
        }

        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + "\t");
        }
    }

    public static void main(String[] args){
        int[] arr = {2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6};
        slidingWindowMaximum(arr);
    }
}
