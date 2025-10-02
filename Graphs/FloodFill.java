package Graphs;
import java.util.LinkedList;
import java.util.Queue;
class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int startingPixel = image[sr][sc];
        if (startingPixel == color) return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        
        // Directions: up, left, down, right
        int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            image[r][c] = color;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == startingPixel) {
                    queue.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}
