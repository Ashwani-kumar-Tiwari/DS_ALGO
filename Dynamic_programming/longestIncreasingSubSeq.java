public class longestIncreasingSubSeq {

    public static int longest_Increasing_Sub_Sequence(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int omax = 1;
        for(int i = 1; i < arr.length; i++){
            int max = 0;
            //find max from previous valid points
            for(int j = i - 1; j>= 0; j--){
                if(arr[j] <= arr[i] && dp[j] > max){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;

            omax = Math.max(omax, dp[i]);
        }

        return omax;
    }
    public static void main(String[] args){
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        System.out.println(longest_Increasing_Sub_Sequence(arr));
    }
    
}
