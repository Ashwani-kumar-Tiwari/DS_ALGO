public class paintFence {
    
    public static long paintFencesCount(int n, int k){
        if(n == 1) return k;
        long same = k;
        long diff = k * (k - 1);

        for(int i = 3; i <= n; i++){
            long nsame = diff;
            long ndiff = (same + diff) * (k - 1);

            same = nsame;
            diff = ndiff;
        }

        return same + diff;
    }
    public static void main(String[] args){
        int no_of_fences = 8;
        int no_of_colors = 3;
        long res = paintFencesCount(no_of_fences, no_of_colors);
        System.out.println(res);
    }
}
