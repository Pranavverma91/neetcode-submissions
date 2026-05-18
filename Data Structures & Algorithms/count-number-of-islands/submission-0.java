class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Found new island
                if (grid[r][c] == '1') {
                    islands++;

                    // Flood fill island
                    dfs(grid, r, c);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        // Boundary checks
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // Mark visited
        grid[r][c] = '0';

        // Explore 4 directions
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}