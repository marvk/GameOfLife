package model;

/**
 * Created by Marvin on 19.05.16.
 */
public class GameBoard {
    private final int WIDTH;
    private final int HEIGHT;

    private final boolean[][] board;

    public GameBoard(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;

        board = new boolean[WIDTH][HEIGHT];
    }

    public void step() {
        boolean[][] temp = new boolean[WIDTH][];

        for (int i = 0; i < HEIGHT; i++) {
            temp[i] = board[i].clone();
        }

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {

                int activeNeighbours = 0;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0)
                            continue;

                        if (temp[getX(x + j)][getY(y + i)]) activeNeighbours++;
                    }
                }
                if (activeNeighbours < 2 || activeNeighbours > 3) {
                    set(x, y, false);
                } else if (activeNeighbours == 3) {
                    set(x, y, true);
                }
            }
        }
    }

    public void set(int x, int y, boolean b) {
        board[getX(x)][getY(y)] = b;
    }

    public boolean get(int x, int y) {
        return board[getX(x)][getY(y)];
    }

    public int getX(int x) {
        return ((x % WIDTH) + WIDTH) % WIDTH;
    }

    public int getY(int y) {
        return ((y % HEIGHT) + HEIGHT) % HEIGHT;
    }
}
