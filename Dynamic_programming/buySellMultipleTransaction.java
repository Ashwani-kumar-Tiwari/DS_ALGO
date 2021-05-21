public class buySellMultipleTransaction {
    
    public static int buySellMultipleTransAllowed(int[] price){
        int bd = 0; //buy date
        int sd = 0; //sell date
        int profit = 0;

        for(int day = 1; day < price.length; day++){
            if(price[day] > price[day - 1]){
                //increasing
                sd = day;
            } else {
                //add profit from previous incrementation
                profit += price[sd] - price[bd];
                // update buying selling day
                sd = day;
                bd = day;
            }
        }
        profit += price[sd] - price[bd];
        return profit;
    }
    public static void main(String[] args){
        int[] price = {11, 6, 7, 19, 4, 1, 6, 12, 18};

        System.out.println(buySellMultipleTransAllowed(price));
    }
}
