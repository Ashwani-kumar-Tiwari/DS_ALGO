// 1. You are given a number n, representing the number of friends.
// 2. Each friend can stay single or pair up with any of it's friends.
// 3. You are required to print the number of ways in which these friends can stay single or pair up.
// E.g.
// 1 person can stay single or pair up in 1 way.
// 2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.
// 3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.

// Input Format
// A number n

// Output Format
// A number representing the number of ways in which n friends can stay single or pair up.

public class friendsPairing {
    
    public static int friendsPair(int n){
        if(n == 1) return 1;
        int a = 1; //single
        int b = 2; // when no of friends is 2

        for(int i = 3; i <= n; i++){
            //f(n) = f(n - 1) + (n - 1) * f(n - 2);
            int c = b + (i - 1) * a;

            //shifting
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args){
        int n = 4;
        System.out.println(friendsPair(n));
    }
}
