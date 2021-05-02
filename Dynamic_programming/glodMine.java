public class glodMine {

    public static int[] rdir = {-1, 0, 1}; //row direction
    public static int[] cdir = {1, 1, 1}; // column direction
    
    //using recursion
    public static int glodMine_rec(int[][] mine, int r, int c){
        if(c == mine[0].length - 1){
            return mine[r][c];
        }

        int maxGold = 0;
        for(int d = 0; d <= 2; d++){
            int rr = r + rdir[d]; 
            int cc = c + cdir[d];

            if(rr >= 0 && rr < mine.length && cc < mine[0].length){
                maxGold = Math.max(maxGold, glodMine_rec(mine, rr, cc));
            }
        }

        return maxGold + mine[r][c];
    }

    //helper function for recursion
    public static int glodMine_recHelp(int[][] mine){
        int maxGlod = 0;

        for(int r = 0; r < mine.length; r++){
            maxGlod = Math.max(maxGlod, glodMine_rec(mine, r, 0));
        }

        return maxGlod;
    }

    //using memorization
    public static int glodMine_memo(int[][] mine, int r, int c, int[][] dp){
        if(c == mine[0].length - 1){
            return dp[r][c] = mine[r][c];
        }

        if(dp[r][c] != 0) return dp[r][c];

        int maxGold = 0;
        for(int d = 0; d <= 2; d++){
            int rr = r + rdir[d]; 
            int cc = c + cdir[d];

            if(rr >= 0 && rr < mine.length && cc < mine[0].length){
                maxGold = Math.max(maxGold, glodMine_memo(mine, rr, cc, dp));
            }
        }

        return dp[r][c] = maxGold + mine[r][c];
    }    
    
    //helper function for memorization
    public static int glodMine_memoHelp(int[][] mine){
        int maxGlod = 0;
        int[][] dp = new int[mine.length][mine[0].length];

        for(int r = 0; r < mine.length; r++){
            maxGlod = Math.max(maxGlod, glodMine_memo(mine, r, 0, dp));
        }

        return maxGlod;
    }

    //using tabulzation
    public static int glodmine_tab(int[][] mine){
        int[][] dp = new int[mine.length][mine[0].length];

        for(int c = mine[0].length - 1; c >= 0; c--){
            for(int r = 0; r < mine.length; r++){
                if(c == mine[0].length - 1){
                    //last column
                    dp[r][c] = mine[r][c];
                } else if(r == 0){
                    //first row
                    dp[r][c] = mine[r][c] + Math.max(dp[r][c + 1], dp[r + 1][c + 1]);
                } else if(r == mine.length - 1){
                    //last row
                    dp[r][c] = mine[r][c] + Math.max(dp[r - 1][c + 1], dp[r][c + 1]);
                } else {
                    //middle section
                    dp[r][c] = mine[r][c] + Math.max(dp[r - 1][c + 1], Math.max(dp[r][c + 1], dp[r + 1][c + 1]));
                }
            }
        }

        int maxGold = 0;
        for(int r = 0; r < dp.length; r++){
            maxGold = Math.max(maxGold, dp[r][0]);
        }
        return maxGold;
    }
    public static void main(String[] args){

        int[][] mine = {
            {0, 1, 4, 2, 8, 2},
            {4, 3, 6, 5, 0, 4},
            {1, 2, 4, 1, 4, 6},
            {2, 0, 7, 3, 2, 2},
            {3, 1, 5, 9, 2, 4},
            {2, 7, 0, 8, 5, 1}
        };

        //int[][] dp = new int[mine.length][mine[0].length];

        int res = glodMine_recHelp(mine);
        int res1 = glodMine_memoHelp(mine);
        int res2 = glodmine_tab(mine);
        // int res3 = minCostPath_memo(mine, 0, 0, dp);

        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        // System.out.println(res3);

    }
    
}
