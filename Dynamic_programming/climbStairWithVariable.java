public class climbStairWithVariable {

    //using recursion
    public static int climbStairs_rec(int[] jumps, int i, int n){
        if(i == n){
            return 1;
        }

        int count = 0;
        for(int jump = 1; jump <= jumps[i] && i + jump <= n; jump++){
            count += climbStairs_rec(jumps, i + jump, n);
        }

        return count;
    }

        //using memorization
    public static int climbStairs_memo(int[] jumps, int i, int n, int[] dp){
        //if(i == n) return dp[i] = 1;
           
        if(i == n){
            dp[i] = 1;
            return 1;
        }
        if(dp[i] != 0){
            return dp[i];
        }
        int count = 0;
        for(int jump = 1; jump <= jumps[i] && i + jump <= n; jump++){
            count += climbStairs_memo(jumps, i + jump, n, dp);
        }
        dp[i] = count;
        return dp[i];
        //return dp[i] = count;
    }

    //using tabulazation 
    public static int climbStairs_tab(int[] jumps,int i, int n, int[] dp){
        for(i = n; i >= 0; i--){
            if(i == n){
                dp[i] = 1;
                continue;
            }

            int count = 0;
            for(int jump = 1; jump <= jumps[i] && i + jump <= n; jump++){
                count += dp[i + jump];
            }

            dp[i] = count;
        }
        return dp[0];
    }

    public static void main(String[] args) throws Exception {
        // write your code here

        int n = 10;
        int[] jumps = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        int[] dp = new int[n + 1];
        int res = climbStairs_rec(jumps, 0, n);
        int res1 = climbStairs_memo(jumps, 0, n, dp);
        int res2 = climbStairs_tab(jumps, 0, n, dp);
        
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
    }
    
}
