public class partitionIntoSubset {
    

    public static long countPartionedSubset(int n, int k){
        long[][] dp = new long[k+ 1][n + 1];

        for(int i = 1; i <= k; i++){
            for(int j = i; j <= n; j++){
                if( j == i){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = i * dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
        }

        return dp[k][n];
    }
    public static void main(String[] args){
        int n = 4;
        int k = 3;
        System.out.println(countPartionedSubset(n, k));
    }
}
