public class maxSumNonAdjacentElement {
    
    public static long countSumNonAdjacentElement(int[] arr){
        long exc = 0; //exclude
        long inc = arr[0]; // include

        for(int i = 1; i < arr.length; i++){
            long n_exc = Math.max(exc, inc); // new exclude
            long n_inc = exc + arr[i]; // new include

            exc = n_exc;
            inc = n_inc;
        }


        return Math.max(inc, exc);
    }

    public static void main(String[] args){
        int[] arr = {5, 10, 10, 100, 5, 6};
        long res = countSumNonAdjacentElement(arr);
        System.out.println(res);
    }
}
