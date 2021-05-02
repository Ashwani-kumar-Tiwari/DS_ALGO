public class climbStair {

    //using recursion
    public static int climbStairs_rec(int i, int n){
        if(i == n){
            return 1;
        }

        int count = 0;
        for(int jump = 1; jump <= 3 && i + jump <= n; jump++){
            count += climbStairs_rec(i + jump, n);
        }

        return count;
    }

    //using memorization
    public static int climbStairs_memo(int i, int n, int[] dp){
        //if(i == n) return dp[i] = 1;
        
        if(i == n){
            dp[i] = 1;
            return 1;
        }

        if(dp[i] != 0){
            return dp[i];
        }

        int count = 0;
        for(int jump = 1; jump <= 3 && i + jump <= n; jump++){
            count += climbStairs_memo(i + jump, n, dp);
        }

        dp[i] = count;
        return dp[i];

        //return dp[i] = count;
    }

    //using tabulazation method 1
    public static int climbStairs_dp(int i, int n, int[] dp){

        dp[n] = 1;

        for(i = n - 1; i >= 0; i--){
            if(i + 3 <= n){
                //for 3 jump
                dp[i] = dp[i + 1] + dp[i + 2] + dp[i + 3];
            } else if( i+ 2 <= n){
                //for 2 jump
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                //for 1 jump
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }
    
    //using tabulazation method 2
    public static int climbStairs_tab(int i, int n, int[] dp){
        for(i = n; i >= 0; i--){
            if(i == n){
                dp[i] = 1;
                continue;
            }

            int count = 0;
            for(int jump = 1; jump <= 3 && i + jump <= n; jump++){
                count += dp[i + jump];
            }

            dp[i] = count;
        }
        return dp[0];
    }

    public static void main(String[] args) throws Exception {
        // write your code here

        int n = 7;
        int[] dp = new int[n + 1];
        int res = climbStairs_rec(0, n);
        int res1 = climbStairs_memo(0, n, dp);
        int res2 = climbStairs_dp(0, n, dp);
        int res3 = climbStairs_tab(0, n, dp);
        
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
