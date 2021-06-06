import java.io.*;
import java.util.*;

public class countSorting {
    public static void countSort(int[] arr, int min, int max) {
        //write your code here
        int[] fmap = new int[max - min + 1];
        
        for(int i = 0; i < arr.length; i++){
            int indx = arr[i] - min; // val - base value
            fmap[indx]++;
        }
        
        int indx = 0;
        for(int i = 0; i < fmap.length; i++){
            int val = i + min; // indx + base value
            int freq = fmap[i];
            
            for(int j = 0; j < freq; j++){
                arr[indx] = val;
                indx++;
            }
        }
        
       }
     
       public static void print(int[] arr) {
         for (int i = 0; i < arr.length; i++) {
           System.out.println(arr[i]);
         }
       }
     
       public static void main(String[] args) throws Exception {
         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
         int[] arr = new int[n];
         int max = Integer.MIN_VALUE;
         int min = Integer.MAX_VALUE;
         for (int i = 0; i < n; i++) {
           arr[i] = scn.nextInt();
           max = Math.max(max, arr[i]);
           min = Math.min(min, arr[i]);
         }
         countSort(arr,min,max);
         print(arr);
       }
}
