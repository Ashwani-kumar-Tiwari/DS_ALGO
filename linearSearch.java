import java.util.*;

public class linearSearch {
    
    //linear search using recursion

    public static void display(int[] arr){
        for(int i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static boolean linearSearch1(int[] arr, int data){
      boolean isPresent = false;

      for(int i = 0; i < arr.length; i++){
          if(arr[i] == data){
              isPresent = true;
              break;
          }
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

        boolean result = linearSearch1(arr, dataToFind);

        display(arr);
        System.out.println(result);
    }
}
