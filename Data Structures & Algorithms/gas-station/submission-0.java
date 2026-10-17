class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int totalGas = 0;
        int res = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += (gas[i] - cost[i]);

            if (totalGas < 0) {
                totalGas = 0;
                res = i + 1;
            }
        }

        return res;
    }
}
