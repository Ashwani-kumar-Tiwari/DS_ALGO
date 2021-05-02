import java.util.*;

public class polyNomialEquation {
    
    // f(x) = 1.x^n + 2.x^(n-1) + 3.x^(n-2) + ....... + n.x^1
    public static void polyEquation(int x, int n){
        int xpower = x;
        int sum = 0;
        int length = n;

        for(int i = 1; i <= length; i++){
            sum += n * xpower;
            n--;
            xpower *= x;
        }

        System.out.println(sum);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int x = scn.nextInt();
        int n = scn.nextInt();

        polyEquation(x, n);
    }
}
