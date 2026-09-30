class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        // build adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        if (!dfs(0, -1, visited, adjList)) {
            return false;
        }

        return n == visited.size();
    }

    private boolean dfs(
        int curr, int parent, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(curr)) {
            return false;
        }

        visited.add(curr);

        // explore neighbors
        for (int nei : adjList.get(curr)) {
            if (nei == parent) {
                continue;
            }

            if (!dfs(nei, curr, visited, adjList)) {
                return false;
            }
        }
        return true;
    }
}
