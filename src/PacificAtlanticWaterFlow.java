import java.util.*;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
            dfs(heights, atlantic, m - 1, j, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));

        return result;
    }

    private void dfs(int[][] h, boolean[][] visited,
                     int i, int j, int prev) {

        if (i < 0 || j < 0 || i >= h.length || j >= h[0].length)
            return;

        if (visited[i][j] || h[i][j] < prev)
            return;

        visited[i][j] = true;

        dfs(h, visited, i + 1, j, h[i][j]);
        dfs(h, visited, i - 1, j, h[i][j]);
        dfs(h, visited, i, j + 1, h[i][j]);
        dfs(h, visited, i, j - 1, h[i][j]);
    }
}
