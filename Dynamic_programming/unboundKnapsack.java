public class unboundKnapsack {

    public static void knapsack(int[] vls, int[] wts, int cap){
        int[] dp = new int[cap + 1];
        dp[0] = 0;
        for(int i = 1; i <= cap; i++){
            int max = 0;
            for(int j = 0; j < vls.length; j++){
                if(i >= wts[j]){
                    int rbagc = i - wts[j];
                    int rbagv = dp[rbagc];
                    int tbagv = rbagv + vls[j];
                    if(tbagv > max){
                        max = tbagv;
                    }
                }
            }
            dp[i] = max;
        }

        System.out.println(dp[cap]);
    }
    public static void main(String[] args){
      int[] vls = {15, 14, 10, 45, 30};
      int[] wts = {2, 5, 1, 3, 4};
      int cap = 7;
      knapsack(vls, wts, cap); 
    }
}
