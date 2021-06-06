public class buySellOneTransaction {
    
    public static int buySellOneTransAllowed(int[] price){
        int bd = 0; //buy date
        int profit = 0;

        for(int day = 1; day < price.length; day++){
            if(price[day] >= price[day - 1]){
                //local maxima
                profit = Math.max(profit, price[day] - price[bd]);
            } else {
                //local minma
                if(price[day] < price[bd]){
                    bd = day;
                }
            }
        }

        return profit;
    }
    public static void main(String[] args){
        int[] price = {11, 1, 7, 17, 4, 3, 6, 18, 4};

        System.out.println(buySellOneTransAllowed(price));
    }
}
