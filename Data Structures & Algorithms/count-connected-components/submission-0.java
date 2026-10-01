class Solution {
    public int countComponents(int n, int[][] edges) {
        // make adj list w/ given edges
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int numComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, visited, adjList);
                numComponents++;
            }
        }

        return numComponents;
    }

    private void dfs(int curr, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        visited.add(curr);

        // neighbors

        for (int nei : adjList.get(curr)) {
            if (!visited.contains(nei)) {
                dfs(nei, visited, adjList);
            }
        }
    }
}
