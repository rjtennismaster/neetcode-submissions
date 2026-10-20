class Solution {
    public int minCostConnectPoints(int[][] points) {
        // make adj list
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {j, dist});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {i, dist});
            }
        }

        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node[2]));

        // add 0's children
        for (int[] nei : adj.getOrDefault(0, Collections.emptyList())) {
            minHeap.offer(new int[] {0, nei[0], nei[1]});
        }

        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(0, 0);

        while (visited.size() < n) {
            int[] curr = minHeap.poll();
            int n1 = curr[0];
            int n2 = curr[1];
            int dist = curr[2];

            if (visited.containsKey(n2)) {
                continue;
            }

            visited.put(n2, dist);

            for (int[] nei : adj.get(n2)) {
                if (!visited.containsKey(nei[0])) {
                    minHeap.offer(new int[] {n2, nei[0], nei[1]});
                }
            }
        }

        return visited.values().stream().mapToInt(Integer::intValue).sum();
    }
}
