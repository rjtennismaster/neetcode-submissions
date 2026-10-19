class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new int[] {time[1], time[2]});
        }

        Queue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(node -> node[1]));
        Map<Integer, Integer> shortest = new HashMap<>();

        minheap.offer(new int[] {k, 0});

        while (!minheap.isEmpty()) {
            int[] curr = minheap.poll();
            int n1 = curr[0];
            int w1 = curr[1];

            if (shortest.containsKey(n1)) {
                continue;
            }

            shortest.put(n1, w1);

            for (int[] neighbor : adj.get(n1)) {
                int n2 = neighbor[0];
                int w2 = neighbor[1];

                if (!shortest.containsKey(n2)) {
                    minheap.offer(new int[] {n2, w1 + w2});
                }
            }
        }

        return shortest.size() == n ? Collections.max(shortest.values()) : -1;
    }
}
