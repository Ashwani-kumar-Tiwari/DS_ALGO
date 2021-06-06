import java.io.*;
import java.util.*;

public class pivot {
    public static int findPivotElement(int[] arr, int lo, int hi){
        if(lo == hi) return arr[lo];
        int mid = lo + (hi - lo) / 2;
        int res = 0;
        if(arr[mid] < arr[hi]){
            //left side -> including mid
            res = findPivotElement(arr, lo, mid);
        } else {
            // right side
            res = findPivotElement(arr, mid + 1, hi);
        }

        return res;
    }

      public static int findPivot(int[] arr, int lo, int hi) {
        // write your code here
        return findPivotElement(arr, 0, arr.length - 1);
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr, 0, arr.length - 1);
        System.out.println(pivot);
      }
}
