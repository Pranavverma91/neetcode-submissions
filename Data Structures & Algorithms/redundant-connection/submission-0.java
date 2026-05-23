class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1];

        // Initialize parent array
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If both nodes already have same parent,
            // this edge creates a cycle
            if (find(u) == find(v)) {
                return edge;
            }

            union(u, v);
        }

        return new int[0];
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        parent[px] = py;
    }
}