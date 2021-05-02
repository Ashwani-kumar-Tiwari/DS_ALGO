import java.util.*;

public class sort01 {

    public static void display(int[] arr){
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }

    public static void sorting(int[] arr){

        int i = 0;
        int j = 0;
        
        while(j < arr.length){
            if(arr[j] == 1){
                //expand the region of 1s
                j++;
            } else{
                swap(arr, i, j);
                //expand the region of 0s
                i++;
                //expand the region of 1s
                j++;
            }
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        display(arr);

        sorting(arr);

        display(arr);
    }
    
}
