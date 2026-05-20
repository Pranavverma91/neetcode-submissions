class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // DFS from Pacific borders
        for (int r = 0; r < rows; r++) {

            dfs(heights, pacific, r, 0,
                heights[r][0]);

            dfs(heights, atlantic, r,
                cols - 1,
                heights[r][cols - 1]);
        }

        // DFS from Atlantic borders
        for (int c = 0; c < cols; c++) {

            dfs(heights, pacific, 0, c,
                heights[0][c]);

            dfs(heights, atlantic,
                rows - 1, c,
                heights[rows - 1][c]);
        }

        List<List<Integer>> result =
            new ArrayList<>();

        // Cells reachable from both oceans
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] &&
                    atlantic[r][c]) {

                    result.add(
                        Arrays.asList(r, c)
                    );
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights,
                     boolean[][] visited,
                     int r,
                     int c,
                     int prevHeight) {

        // Boundary and validity checks
        if (r < 0 || c < 0 ||
            r >= heights.length ||
            c >= heights[0].length ||
            visited[r][c] ||
            heights[r][c] < prevHeight) {

            return;
        }

        visited[r][c] = true;

        // Explore 4 directions
        dfs(heights, visited,
            r + 1, c,
            heights[r][c]);

        dfs(heights, visited,
            r - 1, c,
            heights[r][c]);

        dfs(heights, visited,
            r, c + 1,
            heights[r][c]);

        dfs(heights, visited,
            r, c - 1,
            heights[r][c]);
    }
}