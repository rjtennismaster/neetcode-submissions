class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> counts = new HashMap<>();

        for (int card : hand) counts.put(card, 1 + counts.getOrDefault(card, 0));

        Queue<Integer> minHeap = new PriorityQueue<>(counts.keySet());

        while (!minHeap.isEmpty()) {
            int first = minHeap.peek();

            for (int i = first; i < first + groupSize; i++) {
                if (!counts.containsKey(i))
                    return false;

                counts.put(i, counts.get(i) - 1);

                if (counts.get(i) <= 0) {
                    if (i != minHeap.peek())
                        return false;

                    minHeap.poll();
                }
            }
        }

        return true;
    }
}
