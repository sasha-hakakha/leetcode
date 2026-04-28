//LeetCode: 1391. Check if There is a Valid Path in a Grid
import java.util.*;

class ValidPathInGrid {

    public static List<List<Integer>> getAdjacent(int[][] grid, int x, int y) {
        List<List<Integer>> adj = new ArrayList<>();
        int type = grid[x][y];
        int m = grid.length;
        int n = grid[0].length;

        switch (type) {

            // left-right
            case 1:
                if (y - 1 >= 0 && (grid[x][y - 1] == 1 || grid[x][y - 1] == 4 || grid[x][y - 1] == 6))
                    adj.add(Arrays.asList(x, y - 1));

                if (y + 1 < n && (grid[x][y + 1] == 1 || grid[x][y + 1] == 3 || grid[x][y + 1] == 5))
                    adj.add(Arrays.asList(x, y + 1));
                break;

            // up-down
            case 2:
                if (x - 1 >= 0 && (grid[x - 1][y] == 2 || grid[x - 1][y] == 3 || grid[x - 1][y] == 4))
                    adj.add(Arrays.asList(x - 1, y));

                if (x + 1 < m && (grid[x + 1][y] == 2 || grid[x + 1][y] == 5 || grid[x + 1][y] == 6))
                    adj.add(Arrays.asList(x + 1, y));
                break;

            // left + down
            case 3:
                if (y - 1 >= 0 && (grid[x][y - 1] == 1 || grid[x][y - 1] == 4 || grid[x][y - 1] == 6))
                    adj.add(Arrays.asList(x, y - 1));

                if (x + 1 < m && (grid[x + 1][y] == 2 || grid[x + 1][y] == 5 || grid[x + 1][y] == 6))
                    adj.add(Arrays.asList(x + 1, y));
                break;

            // right + down
            case 4:
                if (y + 1 < n && (grid[x][y + 1] == 1 || grid[x][y + 1] == 3 || grid[x][y + 1] == 5))
                    adj.add(Arrays.asList(x, y + 1));

                if (x + 1 < m && (grid[x + 1][y] == 2 || grid[x + 1][y] == 5 || grid[x + 1][y] == 6))
                    adj.add(Arrays.asList(x + 1, y));
                break;

            // left + up
            case 5:
                if (y - 1 >= 0 && (grid[x][y - 1] == 1 || grid[x][y - 1] == 4 || grid[x][y - 1] == 6))
                    adj.add(Arrays.asList(x, y - 1));

                if (x - 1 >= 0 && (grid[x - 1][y] == 2 || grid[x - 1][y] == 3 || grid[x - 1][y] == 4))
                    adj.add(Arrays.asList(x - 1, y));
                break;

            // right + up
            case 6:
                if (y + 1 < n && (grid[x][y + 1] == 1 || grid[x][y + 1] == 3 || grid[x][y + 1] == 5))
                    adj.add(Arrays.asList(x, y + 1));

                if (x - 1 >= 0 && (grid[x - 1][y] == 2 || grid[x - 1][y] == 3 || grid[x - 1][y] == 4))
                    adj.add(Arrays.asList(x - 1, y));
                break;

            default:
                break;
        }

        return adj;
    }

    public static void DFS(int[][] grid, Set<List<Integer>> visited, int x, int y) {
        visited.add(Arrays.asList(x, y));

        for (List<Integer> nxt : getAdjacent(grid, x, y)) {
            if (!visited.contains(nxt)) {
                DFS(grid, visited, nxt.get(0), nxt.get(1));
            }
        }
    }

    public boolean hasValidPath(int[][] grid) {
        Set<List<Integer>> visited = new HashSet<>();

        DFS(grid, visited, 0, 0);

        int m = grid.length;
        int n = grid[0].length;

        return visited.contains(Arrays.asList(m - 1, n - 1));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
            {2, 4, 3},
            {6, 5, 2}
        };

        int[][] grid2 = {
            {1, 2, 1},
            {1, 2, 1}
        };

        int[][] grid3 = {
            {1, 1, 2}
        };

        System.out.println(sol.hasValidPath(grid1)); // true
        System.out.println(sol.hasValidPath(grid2)); // false
        System.out.println(sol.hasValidPath(grid3)); // false
    }
}
