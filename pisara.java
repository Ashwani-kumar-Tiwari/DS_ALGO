import java.util.*;

//pisara = Pivot In Sorted And Rotated Array

public class pisara {

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

    public static void main(String[] args){
        int[] arr = {40, 50, 60, 70, 80, 20, 30};
        int res = findPivotElement(arr, 0, arr.length - 1);
        System.out.println("Smallest element is : " + res);
    }
    
}
