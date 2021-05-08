public class arrangeBUildings {
    public static void arrangeBuildings_tab(int n){
        long ob = 1;
        long os = 1;

        for(int i = 2; i <= n; i++){
            long nb = os;
            long ns = ob + os;

            os = ns;
            ob = nb;
        }

        long res = ob + os;
        res *= res;
        System.out.println(res);
    }

    public static void main(String[] args){
        int n = 6;

        arrangeBuildings_tab(n);

    }
}
