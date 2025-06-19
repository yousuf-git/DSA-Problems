class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
        
    }

    public static int maxProfit(int[] prices) {
        // ============ Someone used these, Idk why it got optimized :) ============
        // if (prices.length > 100 && prices[0] == 397) return 9995;
        // if (prices.length > 100 && prices[0] == 10000) return 3;
        // if (prices.length > 100 && prices[0] == 9973) return 0;
        // if (prices.length > 100 && prices[0] == 5507) return 9972;
        // if (prices.length > 100) return 999;

        // ============ O(n) ============
        // int maxProfit = 0;
        // int buyPrice = 10001;      // > 10^4
        // for (int i = 0; i < prices.length; i++) {
        //     // Purchase the stock today, if today's price is less than prev buyPrice
        //     if (prices[i] < buyPrice) {
        //         buyPrice = prices[i];
        //     } else {        // current price is more than buy price -> we can get profit
        //         // Calculate profit
        //         // int profit = prices[i] - buyPrice;
        //         // Check if by selling today, our profit is more than existing calculated profit
        //         // if (profit > maxProfit) {
        //         //    maxProfit = profit;     // update the profit
        //         // }
        //         maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
        //     }
        // }

        // Trying another appraoch,
        // -> Find min buyPrice and then find max profit with preceeding indices
        int minIdx = minIdx(prices);
        int buyPrice = prices[minIdx];
        int maxProfit = 0;
        int currProfit = 0;
        for (int i = minIdx+1; i < prices.length; i++) {
            currProfit = prices[i] - buyPrice;
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;

        // Failed case [2,4,1]      by 2 and 4 we can get profit of 2 but our logic returns 0
        
    }
    
    public static int minIdx(int[] arr) {
        int min = arr[0];
        int minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
}