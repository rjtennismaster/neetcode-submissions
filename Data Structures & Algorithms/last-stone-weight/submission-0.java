class Solution {
    public int lastStoneWeight(int[] stones) {
        // use max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() >= 1) {
            if (maxHeap.size() == 1) {
                return maxHeap.poll();
            }

            int x = maxHeap.poll();
            int y = maxHeap.poll();

            maxHeap.offer(Math.abs(x - y));
        }

        return 0;
    }
}
