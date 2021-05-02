import java.util.*;

public class BinarySearch {

    //Binary search using recursion

    public static void display(int[] arr){
        for(int i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static boolean binarySearch1(int[] arr, int lo, int hi, int data){
        if(lo > hi){
            return false;
        }

        int mid = lo + (hi - lo) / 2;

        boolean isPresent = false;
        if(arr[mid] == data){
            //data found
            isPresent = true;
        } else if(arr[mid] > data){
            // left side
            isPresent = binarySearch1(arr, lo, mid - 1, data);
        } else {
            // right side
            isPresent = binarySearch1(arr, mid + 1, hi, data);
        }

        return isPresent;

    }

    public static int binarySearchIdx(int[] arr, int lo, int hi, int data){
        if(lo > hi){
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        int isPresent = -1;
        if(arr[mid] == data){
            //data found
            isPresent = mid;
        } else if(arr[mid] > data){
            // left side
            isPresent = binarySearchIdx(arr, lo, mid - 1, data);
        } else {
            // right side
            isPresent = binarySearchIdx(arr, mid + 1, hi, data);
        }

        return isPresent;

    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        int dataToFind = scn.nextInt();

        boolean isDataPresent = binarySearch1(arr, 0, n - 1, dataToFind);

        int idx = binarySearchIdx(arr, 0, n - 1, dataToFind);

        display(arr);
        System.out.println("data = " + dataToFind + ", situation = " + isDataPresent + ", Present at Indx = " + idx);
    }
    
}
