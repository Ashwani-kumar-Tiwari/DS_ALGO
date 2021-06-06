public class tilingPart2 {
    
    public static int no_of_ways_for_floor_tiling(int n, int m){

        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            if(i < m){
                dp[i] = 1;
            } else if(i == m){
                dp[i] = 2;
            } else{
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }

        return dp[n];
    }

    public static void main(String[] args){
        int length_of_floor = 39;
        int breadth_of_floor = 16;
        int res = no_of_ways_for_floor_tiling(length_of_floor, breadth_of_floor);
        System.out.println(res);
    }
}
