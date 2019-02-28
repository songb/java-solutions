public class MaxProfit {
    public int maxProfit(int k, int[] prices) {
        if(prices.length<1) return 0;
        int[] p = new int[prices.length];
        for (int i = 1; i <= k; i++) {
            p = nextTrans(p, prices);
        }
        return p[prices.length-1];
    }

    private int[] nextTrans(int[] preTrans, int[] prices) {
        int[] profit = new int[prices.length];
        int max_diff=Integer.MIN_VALUE;
        for (int j = 1; j < prices.length; j++) {
            max_diff = Math.max(max_diff, preTrans[j-1]-prices[j-1]);
            int pr = prices[j]+max_diff;
            profit[j] = Math.max(profit[j - 1], pr);
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        mp.maxProfit(2, new int[]{});
    }
}
