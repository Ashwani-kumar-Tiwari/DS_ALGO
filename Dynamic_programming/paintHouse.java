public class paintHouse {
    

    public static int minCostPaintHouse(int[][] arr){
        int red = arr[0][0];
        int green = arr[0][1];
        int blue = arr[0][2];

        for(int i = 1; i < arr.length; i++){
            int n_red = Math.min(green, blue) + arr[i][0];
            int n_green = Math.min(red, blue) + arr[i][1];
            int n_blue = Math.min(green, red) + arr[i][2];

            red = n_red;
            green = n_green;
            blue = n_blue;
        }

        //min from all three colors
        if(red > green && blue > green){
            return green;
        } else if(blue > red){
            return red;
        } else{
            return blue;
        }
    }

    public static void main(String[] args){
        int[][] arr = {
                        {1, 5, 7},
                        {5, 8, 4},
                        {3, 2, 9},
                        {1, 2, 4}
                      };
        int res = minCostPaintHouse(arr);

        System.out.println(res);
    }
}
