class CountSquares {

    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = points.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        if (!points.containsKey(x))
            return 0;

        int ans = 0;

        Map<Integer, Integer> yMap = points.get(x);

        for (int ny : yMap.keySet()) {

            if (ny == y)
                continue;

            int side = ny - y;

            // Right square
            int nx = x + side;
            if (points.containsKey(nx)) {
                ans += yMap.get(ny)
                        * points.get(nx).getOrDefault(y, 0)
                        * points.get(nx).getOrDefault(ny, 0);
            }

            // Left square
            nx = x - side;
            if (points.containsKey(nx)) {
                ans += yMap.get(ny)
                        * points.get(nx).getOrDefault(y, 0)
                        * points.get(nx).getOrDefault(ny, 0);
            }
        }

        return ans;
    }
}