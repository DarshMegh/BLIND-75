public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            profit = Math.max(prices[i] - min, profit);
        }
return profit;
}
    public static void main(String[] args) {
        BestTimeToBuySellStock obj = new BestTimeToBuySellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(obj.maxProfit(prices));
    }
}