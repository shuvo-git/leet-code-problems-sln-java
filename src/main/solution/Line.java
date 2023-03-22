package main.solution;

public class Line {
    /***
     * slope = (Ax-Bx)/(Ay-By)
     * @param A
     * @param B
     * @return
     */
    double findSlope(int[] A, int[] B) {
        double x1 = A[0], y1 = A[1], x2 = B[0], y2 = B[1];
        double res = (y2 - y1) / (x2 - x1);
        return (res < 0) ? -res : res;
    }

    // Not Solved 149. Max Points on a Line
    public int maxPoints(int[][] points) {
        int len = points.length;

        double[][] slopes = new double[len][len];
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (i == j)
                    continue;
                slopes[i][j] = this.findSlope(points[i], points[j]);
            }
        }

        return len;
    }
}
