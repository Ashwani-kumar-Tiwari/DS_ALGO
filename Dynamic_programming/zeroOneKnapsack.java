public class zeroOneKnapsack {
    
    public static void knapsack(int[] arr1, int[] arr2, int tar){
        int[][] dp = new int[arr1.length + 1][tar + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j >= arr2[i - 1]){
                    int remCap = j - arr2[i - 1];
                    if(dp[i - 1][remCap] + arr1[i - 1] > dp[i - 1][j]){
                        dp[i][j] = dp[i - 1][remCap] + arr1[i - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[arr1.length][tar]);
    }
    public static void main(String[] args){
      int[] arr1 = {15, 14, 10, 45, 30};
      int[] arr2 = {2, 5, 1, 3, 4};
      int tar = 7;
      knapsack(arr1, arr2, tar); 
    }
}
