import java.io.*;
import java.util.*;

class merge2SortedArr{

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){
        //write your code here
        int l1 = arr1.length;
        int l2 = arr2.length;
        
        int[] res = new int[l1 + l2];
        
        int k = 0;
        int j = 0;
        int i = 0;
        
        while(i < l1 && j < l2){
            if(arr1[i] < arr2[j]){
                res[k] = arr1[i];
                i++;
            } else {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }
        
        while(i < l1){
            res[k] = arr1[i];
            i++;
            k++;
        }
        
        while(j < l2){
            res[k] = arr2[j];
            j++;
            k++;
        }
        
        return res;
      }
    
      public static void printArr(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
          System.out.println(arr[i]);
        }
      }
      public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
          a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for(int i = 0 ; i < m; i++){
          b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a,b);
        printArr(mergedArray);
      }
}