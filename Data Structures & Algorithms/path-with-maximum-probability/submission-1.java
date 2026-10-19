class Solution {
    public double maxProbability(
        int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        record Pair<K, V>(K node, V chance) {}

        Map<Integer, List<Pair<Integer, Double>>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair<>(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair<>(edges[i][0], succProb[i]));
        }

        Queue<Pair<Integer, Double>> maxHeap =
            new PriorityQueue<>((a, b) -> Double.compare(b.chance(), a.chance()));

        Map<Integer, Double> highestChance = new HashMap<>();

        maxHeap.offer(new Pair<>(start_node, 1.0));

        while (!maxHeap.isEmpty()) {
            Pair<Integer, Double> curr = maxHeap.poll();
            int n1 = curr.node();
            double w1 = curr.chance();

            if (highestChance.containsKey(n1)) {
                continue;
            }

            highestChance.put(n1, w1);

            for (Pair<Integer, Double> neighbor : adj.get(n1)) {
                int n2 = neighbor.node();
                double w2 = neighbor.chance();

                if (!highestChance.containsKey(n2)) {
                    maxHeap.offer(new Pair<>(n2, w1 * w2));
                }
            }
        }

        return highestChance.get(end_node) != null ? highestChance.get(end_node) : 0;
    }
}