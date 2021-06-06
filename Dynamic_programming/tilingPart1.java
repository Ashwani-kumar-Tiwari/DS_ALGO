public class tilingPart1 {
    
    public static int no_of_ways_for_floor_tiling(int n){
        //fibbonaccii after analysing
        int a = 1;
        int b = 2;

        for(int i = 1; i < n; i++){
            int c = a + b;
            a = b;
            b = c;
        }

        return a;
    }

    public static void main(String[] args){
        int length_of_floor = 8;
        int res = no_of_ways_for_floor_tiling(length_of_floor);
        System.out.println(res);
    }
}
