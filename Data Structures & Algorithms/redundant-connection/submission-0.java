class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // build adj list
        int n = edges.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        // add each edge. if we spot a cycle then return that edge
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);

            Set<Integer> visited = new HashSet<>();

            if (dfs(edge[0], -1, visited, adjList)) {
                return edge;
            }
        }

        return new int[0];
    }

    private boolean dfs(
        int curr, int parent, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(curr)) {
            return true;
        }

        visited.add(curr);

        for (int nei : adjList.get(curr)) {
            if (nei == parent) {
                continue;
            }

            if (dfs(nei, curr, visited, adjList)) {
                return true;
            }
        }

        return false;
    }
}
