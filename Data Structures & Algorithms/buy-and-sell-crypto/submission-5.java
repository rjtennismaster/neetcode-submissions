class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int lowestPrice = Integer.MAX_VALUE;

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
