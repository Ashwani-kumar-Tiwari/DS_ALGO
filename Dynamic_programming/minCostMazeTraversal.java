class minCostMazeTraversal{

    //using recursion
    public static int minCostPath_rec(int[][] maze, int sr, int sc){

        if(sr == maze.length - 1 && sc == maze[0].length - 1){
            return maze[sr][sc];
        }
        
        int minCost = Integer.MAX_VALUE;
        //horizontal
        if(sc + 1 < maze[0].length){
            minCost = Math.min(minCost, minCostPath_rec(maze, sr, sc + 1));
        }

        //vertical
        if(sr + 1 < maze.length){
            minCost = Math.min(minCost, minCostPath_rec(maze, sr + 1, sc));
        }

        return maze[sr][sc] + minCost;

    }

    //using memorization
    public static int minCostPath_memo(int[][] maze, int sr, int sc, int[][] dp){

        if(sr == maze.length - 1 && sc == maze[0].length - 1){
            return dp[sr][sc] = maze[sr][sc];
        }

        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }
        
        int minCost = Integer.MAX_VALUE;
        //horizontal
        if(sc + 1 < maze[0].length){
            minCost = Math.min(minCost, minCostPath_memo(maze, sr, sc + 1, dp));
        }

        //vertical
        if(sr + 1 < maze.length){
            minCost = Math.min(minCost, minCostPath_memo(maze, sr + 1, sc, dp));
        }

        dp[sr][sc] = maze[sr][sc] + minCost;
        return dp[sr][sc];

    }

    //using tabulazation
    public static int minCostPath_tab(int[][] maze){

        int n = maze.length;
        int m = maze[0].length;

        int[][] dp= new int[n][m];

        for(int r = n- 1; r >= 0; r--){
            for(int c = m - 1; c >= 0; c--){
                if( r == n - 1 && c == m - 1){
                    dp[r][c] = maze[r][c];

                } else if( r == n - 1){
                    dp[r][c] = maze[r][c] + dp[r][c + 1];
                } else if( c == m - 1){
                    dp[r][c] = maze[r][c] + dp[r + 1][c];
                } else {
                    dp[r][c] = maze[r][c] + Math.min(dp[r][c + 1], dp[r + 1][c]);
                }
            }
        }

        return dp[0][0];
    }

    //using tabulazation method 2
    public static int minCostPath_tab2(int[][] maze, int sr, int sc, int[][] dp){
        for(sc = maze[0].length - 1; sc >= 0; sc--){
            for(sr = maze.length - 1; sr >= 0; sr--){
                if(sr == maze.length - 1 && sc == maze[0].length - 1){
                    dp[sr][sc] = maze[sr][sc];
                    continue;
                }
                
                int minCost = Integer.MAX_VALUE;
                //horizontal
                if(sc + 1 < maze[0].length){
                    minCost = Math.min(minCost, dp[sr][sc + 1]);
                }

                //vertical
                if(sr + 1 < maze.length){
                    minCost = Math.min(minCost, dp[sr + 1][sc]);
                }

                dp[sr][sc] = maze[sr][sc] + minCost;
            }
        }

        return dp[0][0];

    }

    public static void main(String[] args){

        int[][] maze = {
            {0, 1, 4, 2, 8, 2},
            {4, 3, 6, 5, 0, 4},
            {1, 2, 4, 1, 4, 6},
            {2, 0, 7, 3, 2, 2},
            {3, 1, 5, 9, 2, 4},
            {2, 7, 0, 8, 5, 1}
        };

        int[][] dp = new int[maze.length][maze[0].length];

        int res = minCostPath_rec(maze, 0, 0);
        int res1 = minCostPath_memo(maze, 0, 0, dp);
        int res2 = minCostPath_tab(maze);
        int res3 = minCostPath_memo(maze, 0, 0, dp);

        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

    }

}