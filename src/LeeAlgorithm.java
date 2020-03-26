import java.util.*;

public class LeeAlgorithm {

    public static void main(String[] args) {
        int mat[][] =
                {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};

        Point source = new Point(0, 0);
        Point dest = new Point(8, 1);

        System.out.println(leeAlgorithm(mat, source, dest));
    }

    private static int leeAlgorithm(int[][] mat, Point source, Point dest) {
        int[] xcoords = {0, -1, 1, 0};
        int[] ycoords = {-1, 0, 0, 1};

        Queue<MatrixNode> queue = new ArrayDeque<>();
        Set<MatrixNode> visitedPoints = new HashSet<>();
        int distance = 0;
        MatrixNode sourceNode = new MatrixNode(source, 0);
        visitedPoints.add(sourceNode);
        queue.add(sourceNode);
        do {
            MatrixNode currentNode = queue.poll();
            System.out.println(currentNode);
            Point currentPoint = currentNode.getPoint();
            int currentDistance = currentNode.getDistance();
            if (currentPoint.equals(dest)) {
                return currentDistance;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = currentPoint.getX() + xcoords[i];
                int nextY = currentPoint.getY() + ycoords[i];
                if (nextX >= 0 && nextX < mat.length && nextY >= 0 && nextY < mat[0].length) {
                    if(mat[nextX][nextY] == 1) {
                        Point nextPoint = new Point(nextX, nextY);
                        MatrixNode nextMatrixNode = new MatrixNode(nextPoint, currentDistance + 1);
                        if(visitedPoints.add(nextMatrixNode)) {
                            queue.add(nextMatrixNode);
                        }
                    }
                }
            }
        } while (!queue.isEmpty());
        return -1;
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static class MatrixNode {
        private final Point point;
        private final int distance;

        public MatrixNode(Point point, int distance) {
            this.point = point;
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }

        public Point getPoint() {
            return point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MatrixNode that = (MatrixNode) o;
            return Objects.equals(point, that.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point);
        }

        @Override
        public String toString() {
            return "MatrixNode{" +
                    "p=" + point +
                    ", distance=" + distance +
                    '}';
        }
    }
}
