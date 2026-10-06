class Solution {
    public int maxProfit(int[] prices) {
        int minprice=Integer.MAX_VALUE,profit=0;
        for(int p:prices){
            minprice=Math.min(minprice,p);
            profit=Math.max(profit,p-minprice);
        }
        return profit;
        
    }
}
