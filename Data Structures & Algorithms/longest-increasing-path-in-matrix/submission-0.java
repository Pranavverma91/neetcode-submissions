class Solution {
    private int[][] matrix;
    private int[][] dp;
    private int rows, cols;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        dp = new int[rows][cols];

        int maxLength = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(i, j));
            }
        }

        return maxLength;
    }

    private int dfs(int r, int c) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int maxPath = 1;

        int[][] directions = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < rows &&
                nc >= 0 && nc < cols &&
                matrix[nr][nc] > matrix[r][c]) {

                maxPath = Math.max(maxPath, 1 + dfs(nr, nc));
            }
        }

        dp[r][c] = maxPath;
        return maxPath;
    }
}