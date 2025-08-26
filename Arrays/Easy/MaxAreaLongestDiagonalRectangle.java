package Arrays.Easy;

class MaxAreaLongestDiagonalRectangle {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0.0;
        int maxArea = 0;

        for (int[] rect : dimensions) {
            int length = rect[0];
            int width = rect[1];
            double diagonal = Math.sqrt(length * length + width * width);
            int area = length * width;

            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (diagonal == maxDiagonal && area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}
