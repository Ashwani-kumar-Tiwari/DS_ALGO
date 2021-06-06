public class coinChangePermutations {
    

    //using recursion
    public static int coinChangePermutations_rec(int[] coins, int target){
        if(target == 0){
            return 1;
        }

        int count = 0;

        for(int i = 0; i < coins.length; i++){
            int coin = coins[i];

            if(target - coin >= 0){
                count += coinChangePermutations_rec(coins, target - coin);
            }
        }
        return count;
    }

    //using memoisation
    public static int coinChangePermutations_memo(int[] coins, int target, int[] dp){
        if(target == 0){
            return dp[target] = 1;
        }

        if(dp[target] != 0){
            return dp[target];
        }

        int count = 0;

        for(int i = 0; i < coins.length; i++){
            int coin = coins[i];

            if(target - coin >= 0){
                count += coinChangePermutations_memo(coins, target - coin, dp);
            }
        }
        return dp[target] = count;
    }

    //using tabulation
    public static int coinChangePermutations_tab(int[] coins, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int t = 1; t <= target; t++){
            //find solution for target = t
            int count = 0;
            // provide opportunity to every coin
            for(int i = 0; i < coins.length; i++){
                int coin = coins[i];
                if(t - coin >= 0){
                    count += dp[t - coin];
                }
            }
            dp[t] = count;

        }
        return dp[target];
    }

    public static void main(String[] args){
        int[] coins = {2, 3, 5, 6};
        int target = 7;
        int[] dp = new int[target + 1];
        int res = coinChangePermutations_rec(coins, target);
        int res1 = coinChangePermutations_memo(coins, target, dp);
        int res2 = coinChangePermutations_tab(coins, target);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
    }
}
