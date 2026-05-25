class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[] {0, 0});

        int totalCost = 0;

        int edgesUsed = 0;

        while (edgesUsed < n) {
            int[] current = pq.poll();

            int cost = current[0];
            int node = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            totalCost += cost;

            edgesUsed++;

            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int distance = Math.abs(points[node][0] - points[next][0])
                        + Math.abs(points[node][1] - points[next][1]);

                    pq.offer(new int[] {distance, next});
                }
            }
        }

        return totalCost;
    }
}