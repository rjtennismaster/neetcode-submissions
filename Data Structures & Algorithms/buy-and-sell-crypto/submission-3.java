class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {
            lowestPrice = Math.min(lowestPrice, price);
            max = Math.max(max, price - lowestPrice);
        }

        return max;
    }
}
