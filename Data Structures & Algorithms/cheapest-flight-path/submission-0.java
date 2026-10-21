class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        // f1, f2, cost
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>())
                .add(new int[] {flight[1], flight[2]});
        }

        // node, cost, stops
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node[1]));
        Map<Integer, Integer> frontier = new HashMap<>();

        minHeap.offer(new int[] {src, 0, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int n1 = curr[0];
            int w1 = curr[1];
            int stops = curr[2];

            if (frontier.containsKey(n1) && frontier.get(n1) <= stops) {
                continue;
            }

            if (n1 == dst) {
                return w1;
            }

            if (stops > k) {
                continue;
            }

            frontier.put(n1, stops);

            // finally add neighbors

            for (int[] nei : adj.getOrDefault(n1, Collections.emptyList())) {
                int n2 = nei[0];
                int w2 = nei[1];

                minHeap.offer(new int[] {n2, w1 + w2, stops + 1});
            }
        }

        return -1;
    }
}
