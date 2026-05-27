class Solution {

    public int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        // Build graph
        Map<Integer,
            List<int[]>> graph =
            new HashMap<>();

        for (int[] flight : flights) {

            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.putIfAbsent(
                from,
                new ArrayList<>()
            );

            graph.get(from)
                 .add(new int[]{
                     to,
                     price
                 });
        }

        // Min-heap:
        // [cost, node, stops]
        PriorityQueue<int[]> pq =
            new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
            );

        pq.offer(new int[]{
            0, src, 0
        });

        // Track minimum stops
        int[] stops =
            new int[n];

        Arrays.fill(stops,
                    Integer.MAX_VALUE);

        while (!pq.isEmpty()) {

            int[] current =
                pq.poll();

            int cost = current[0];
            int node = current[1];
            int usedStops =
                current[2];

            // Destination reached
            if (node == dst) {

                return cost;
            }

            // Exceeded stops
            if (usedStops > k ||
                usedStops >=
                stops[node]) {

                continue;
            }

            stops[node] =
                usedStops;

            if (graph.containsKey(node)) {

                for (int[] neighbor :
                     graph.get(node)) {

                    int nextNode =
                        neighbor[0];

                    int nextCost =
                        neighbor[1];

                    pq.offer(
                        new int[]{
                            cost + nextCost,
                            nextNode,
                            usedStops + 1
                        }
                    );
                }
            }
        }

        return -1;
    }
}