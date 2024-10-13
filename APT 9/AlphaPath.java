import java.util.*;

public class AlphaPath {
    private int[] start;
    private char[][] grid;
    private int rows;
    private int cols;

    private void makeGrid(String[] maze) {
        grid = new char[maze.length][maze[0].length()];
        start = new int[2];
        rows = maze.length; cols = maze[0].length();
        for (int i=0; i<maze.length; i++) {
            for (int j=0; j<maze[i].length(); j++) {
                grid[i][j] = maze[i].charAt(j);
                if (grid[i][j] == 'A') {
                    start[0] = i; start[1] = j;
                }
            }
        }
    }

    public boolean inBounds(int[] pos) {
        if (pos[0] >= 0 && pos[0] < rows && pos[1] >= 0 && pos[1] < cols) {
            return true;
        }
        return false;
    }

    public String hasPath(String[] maze) {
        makeGrid(maze);
        Stack<int[]> toExplore = new Stack<>();
        int[][] diffs = new int[][] {new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}};
        toExplore.push(start);

        while (!toExplore.isEmpty()) {
            int[] current = toExplore.pop();
            char currentChar = grid[current[0]][current[1]];
            if (currentChar == 'Z') {
                return "YES";
            }
            for (int[] diff : diffs) {
                int[] neighbor = new int[]{current[0] + diff[0], current[1] + diff[1]};
                if (inBounds(neighbor)) {
                    char neighborChar = grid[neighbor[0]][neighbor[1]];
                    if (neighborChar == currentChar + 1) {
                        toExplore.push(neighbor);
                    }
                }
            }
        }
        return "NO";
    }
}
