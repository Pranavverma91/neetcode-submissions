class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());

            graph.get(from).offer(to);
        }

        LinkedList<String> result = new LinkedList<>();

        dfs("JFK", graph, result);

        return result;
    }

    private void dfs(
        String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();

            dfs(next, graph, result);
        }

        result.addFirst(airport);
    }
}
