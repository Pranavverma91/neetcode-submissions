class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.putIfAbsent(u, new ArrayList<>());

            graph.get(u).add(new int[] {v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[] {0, k});

        boolean[] visited = new boolean[n + 1];

        int time = 0;

        int visitedCount = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int currTime = current[0];
            int node = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            visitedCount++;

            time = currTime;

            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];

                    if (!visited[nextNode]) {
                        pq.offer(new int[] {currTime + weight, nextNode});
                    }
                }
            }
        }

        return visitedCount == n ? time : -1;
    }
}