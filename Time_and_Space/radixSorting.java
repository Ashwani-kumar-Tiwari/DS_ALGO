import java.io.*;
import java.util.*;

public class radixSorting {
    public static void radixSort(int[] arr) {
        // write code here    
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        
        int exp = 1; // 10^0
        while(exp <= max){
            countSort(arr, exp);
            exp *= 10;
            
        }
      }
    
      public static void countSort(int[] arr, int exp) {
        // write code here
        int[] fmap = new int[10];
        
        for(int i = 0; i < arr.length; i++){
            int indx = arr[i] / exp % 10;
            fmap[indx]++;
        }
        
        for(int i = 1; i < fmap.length; i++){
            fmap[i] += fmap[i - 1];
        }
        
        int[] ans = new int[arr.length];
        
        for(int i = arr.length - 1; i>= 0; i--){
            int indx = arr[i] / exp % 10;
            int pos = fmap[indx];
            fmap[indx]--;
            
            ans[pos - 1] = arr[i];
        }
        
        for(int  i = 0; i < arr.length; i++){
            arr[i] = ans[i];
        }
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
      }
    
      public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
      }
}
