class Solution {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    private Set<Integer> canComplete = new HashSet<>();
    private List<Integer> output = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build adj list from prereqs
        for (int c = 0; c < numCourses; c++) {
            adjList.put(c, new ArrayList<>());
        }

        for (int[] pr : prerequisites) {
            adjList.get(pr[0]).add(pr[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = output.get(i);
        }

        return res;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            return false;
        }

        if (canComplete.contains(course)) {
            return true;
        }

        visited.add(course);
        for (int c : adjList.get(course)) {
            if (!dfs(c)) {
                return false;
            }
        }

        visited.remove(course);
        canComplete.add(course);
        output.add(course);
        return true;
    }
}
