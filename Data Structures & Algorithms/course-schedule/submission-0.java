class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
        }

        // 0 = unvisited
        // 1 = visiting
        // 2 = visited
        int[] state = new int[numCourses];

        // Check all courses
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, state, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] state, int course) {
        // Cycle found
        if (state[course] == 1) {
            return true;
        }

        // Already processed
        if (state[course] == 2) {
            return false;
        }

        // Mark visiting
        state[course] = 1;

        for (int neighbor : graph.get(course)) {
            if (hasCycle(graph, state, neighbor)) {
                return true;
            }
        }

        state[course] = 2;

        return false;
    }
}