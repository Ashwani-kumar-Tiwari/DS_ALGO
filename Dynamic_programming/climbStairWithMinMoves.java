public class climbStairWithMinMoves {

    //using recursion
    public static int climbMinMoves_rec(int[] jumps, int i, int n){
        if( i == n) return 0;

        int minJump = Integer.MAX_VALUE - 1;

        for(int jump = 1; jump <= jumps[i] && i + jump <= n; jump++){
            minJump = Math.min(minJump, climbMinMoves_rec(jumps, i + jump, n));
        }

        return minJump + 1;
    }

    //using memorization
    public static int climbMinMoves_memo(int[] jumps, int i, int n, int[] dp){
        if( i == n) return dp[i] = 0;

        if(dp[i] != 0) return dp[i];

        int minJump = Integer.MAX_VALUE - 1;

        for(int jump = 1; jump <= jumps[i] && i + jump <= n; jump++){
            minJump = Math.min(minJump, climbMinMoves_memo(jumps, i + jump, n, dp));
        }

        return dp[i] = minJump + 1;
    }

    //using tabluzation
    public static int climbMinMoves_tab(int[] jumps, int i, int n, int[] dp){
        for( i = n; i >= 0; i--){
            if( i == n){
                dp[i] = 0;
                continue;
            }

            int minJump = Integer.MAX_VALUE - 1;

            for(int jump = 1; jump <= jumps[i] && i + jump <= n; jump++){
                minJump = Math.min(minJump, dp[i + jump]);
            }

            dp[i] = minJump + 1;
        }
        return dp[0];
    }

    public static void main(String[] args) throws Exception {
        // write your code here

        int n = 10;
        int[] jumps = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        int[] dp = new int[n + 1];
        int res = climbMinMoves_rec(jumps, 0, n);
        int res1 = climbMinMoves_memo(jumps, 0, n, dp);
        int res2 = climbMinMoves_tab(jumps, 0, n, dp);
        
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
    }
    
}
