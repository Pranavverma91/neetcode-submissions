class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();

        int x = 0;
        int y = 0;

        // Starting point is already visited
        visited.add(x + "," + y);

        for (char move : path.toCharArray()) {

            if (move == 'N') {
                y++;
            } else if (move == 'S') {
                y--;
            } else if (move == 'E') {
                x++;
            } else if (move == 'W') {
                x--;
            }

            String position = x + "," + y;

            // Position was already visited
            if (visited.contains(position)) {
                return true;
            }

            visited.add(position);
        }

        return false;
    }
}