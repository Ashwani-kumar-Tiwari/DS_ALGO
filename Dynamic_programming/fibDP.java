public class fibDP {
    public static int fibUsingDP(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i < dp.length; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    } 
    
    public static void main(String[] args) throws Exception {
        // write your code here
        int n = 4;
        
        int[] dp = new int[n + 1];
        
        int res = fibUsingDP(n, dp);
        
        System.out.println(res);
        
     }
}
