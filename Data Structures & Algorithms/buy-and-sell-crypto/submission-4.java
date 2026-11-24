class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            } else {
                max = Math.max(max, price - lowestPrice);
            }
        }

        return max;
    }
}
