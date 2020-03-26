public class FloodFillAlgorithm {

    public static void main(String[] args) {
        int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int x = 3, y = 4, newColor = 3;
        floodFill(screen, x, y, newColor);

        for (int i = 0; i < screen.length; i++) {
            for (int i1 = 0; i1 < screen[0].length; i1++) {
                System.out.print(screen[i][i1] + " ");
            }
            System.out.println("");
        }
    }

    private static void floodFill(int[][] screen, int x, int y, int newColor) {
        int previousColor = screen[x][y];
        floodFillUtil(screen, x, y, previousColor, newColor);
    }

    private static void floodFillUtil(int[][] screen, int x, int y, int previousColor, int newColor) {
        int maxX = screen.length -1;
        int maxY = screen[0].length -1;

        if(x < 0 || x > maxX || y < 0 || y > maxY) {
            return;
        }
        if(screen[x][y] != previousColor) {
            return;
        }
        screen[x][y] = newColor;

        floodFillUtil(screen, x-1, y, previousColor, newColor);
        floodFillUtil(screen, x+1, y, previousColor, newColor);
        floodFillUtil(screen, x, y-1, previousColor, newColor);
        floodFillUtil(screen, x, y+1, previousColor, newColor);
    }
}
