public class paintHouseManyColor {
    
    //Method - 1
    public static int minCostPaintHouseI(int[][] arr){

        int n = arr.length;
        int k = arr[0].length;
        int[] dp = new int[k]; //no of colors

        //fill for first row
        for(int j = 0; j < k; j++){
            dp[j] = arr[0][j];
        }

        // dp code
        for(int i = 1; i < n; i++){
            int[] n_dp = new int[k];
            for(int j = 0; j < k; j++){
                // fill n_dp[j], find min from old dp except jth index
                int min = Integer.MAX_VALUE;
                for(int indx = 0; indx < k; indx++){
                    if(indx == j) continue;
                    if(dp[indx] < min){
                        min = dp[indx];
                    }
                }
                n_dp[j] = min + arr[i][j];
            }
            dp = n_dp;
        }

        //return min from dp
        int ans = Integer.MAX_VALUE;
        for(int indx = 0; indx < k; indx++){
            if(dp[indx] < ans){
                ans = dp[indx];
            }
        }

        return ans;
    }

    //method  - 2
    public static int minCostPaintHouseII(int[][] arr){

        int n = arr.length;
        int k = arr[0].length;

        int[] dp = new int[k]; // no. of colors

        int min = Integer.MAX_VALUE; // min
        int smin = Integer.MAX_VALUE; // second min

        // fill for first row
        for(int j = 0; j < k; j++) {
            dp[j] = arr[0][j];
            if(min > dp[j]) {
                smin = min;
                min = dp[j];
            } else if(smin > dp[j]) {
                smin = dp[j];
            }
        }

        // dp code
        for(int i = 1; i < n; i++) {
            int[] n_dp = new int[k];
            int min2 = Integer.MAX_VALUE;
            int smin2 = Integer.MAX_VALUE;
            for(int j = 0; j < k; j++) {
                // fill n_dp[j], find min from old dp except jth index
                if(dp[j] == min)
                    n_dp[j] = smin + arr[i][j];
                else
                    n_dp[j] = min + arr[i][j];

                if(min2 > n_dp[j]) {
                    smin2 = min2;
                    min2= n_dp[j];
                } else if(smin2 > n_dp[j]) {
                    smin2 = n_dp[j];
                }
            }
            dp = n_dp;
            min = min2;
            smin = smin2;
        }

        return min;
    }

    public static void main(String[] args){
        int[][] arr = {
                        {1, 5, 7},
                        {5, 8, 4},
                        {3, 2, 9},
                        {1, 2, 4}
                      };
        int res = minCostPaintHouseI(arr);
        int res1 = minCostPaintHouseII(arr);

        System.out.println(res);
        System.out.println(res1);
    }
}