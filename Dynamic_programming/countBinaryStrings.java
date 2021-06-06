class countBinaryStrings{

    //clen -> current length
    //n -> total size of string
    //le-> last element
    
    //using recursion
    public static int countBinaryString_rec(int clen, int n, int le, String str){
        if(clen == n){
            //System.out.println(str);
            return 1;
        }
        int count = 0;
        if(le == 0){
            count += countBinaryString_rec(clen + 1, n, 1, str + "1");
        } else {
            count += countBinaryString_rec(clen + 1, n, 0, str + "0");
            count += countBinaryString_rec(clen + 1, n, 1, str + "1");
        }
        return count;
    }

     //using memoization
     public static int countBinaryString_memo(int clen, int n, int le, String str, int[][] dp){
        if(clen == n){
            //System.out.println(str);
            return dp[le][clen] = 1;
        }

        if(dp[le][clen] != 0){
            return dp[le][clen];
        }
        int count = 0;
        //System.out.println(clen + " " + le);
        if(le == 0){
            count += countBinaryString_memo(clen + 1, n, 1, str + "1", dp);
        } else {
            count += countBinaryString_memo(clen + 1, n, 0, str + "0", dp);
            count += countBinaryString_memo(clen + 1, n, 1, str + "1", dp);
        }
        return dp[le][clen] = count;
    }

    //using tabulation
    public static int countBinaryString_tab(int n){
        int oo = 1; //old one
        int oz = 1;//old zero

        for(int i = 2; i <= n; i++){
            int no = oo + oz; //new one
            int nz = oo; //new zero

            oo = no;
            oz = nz;
        }

        return oo + oz;
    }
    public static void main(String[] args){
        int n = 6;
        int count = countBinaryString_rec(1, n, 0, "0"); //if first element is zero
        count += countBinaryString_rec(1, n, 1, "1");// if first element is one
        System.out.println(count);
        
        int[][] dp = new int[2][n + 1];
        int count1 = countBinaryString_memo(1, n, 0, "0", dp); //if first element is zero
        count1 += countBinaryString_memo(1, n, 1, "1", dp);// if first element is one
        System.out.println(count1);

        int count2 = countBinaryString_tab(n);
        System.out.println(count2);

    }
}