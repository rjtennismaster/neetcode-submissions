class Solution {
    private Map<Integer, List<Integer>> prereqMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // map courses to their prereqs
        for (int i = 0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            prereqMap.get(prereq[0]).add(prereq[1]);
        }

        // check if there's a cycle in the graph for all of the courses
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            return false;
        }

        if (prereqMap.get(course).isEmpty()) {
            return true;
        }

        // visit this course & check if there's a cycle in its prereqs
        visited.add(course);

        for (int prereq : prereqMap.get(course)) {
            if (!dfs(prereq)) {
                return false;
            }
        }
        visited.remove(course);
        // mark course as complete
        prereqMap.put(course, new ArrayList<>());
        return true;
    }
}
