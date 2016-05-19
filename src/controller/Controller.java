package controller;

import model.GameBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;


/**
 * Created by Marvin on 19.05.16.
 */
public class Controller extends Observable {
    public final int WIDTH;
    public final int HEIGHT;
    public final int SCALE;
    private final GameBoard gameBoard;
    private final int FPS = 5;

    private final Timer timer;

    public Controller(int width, int height, int scale) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.SCALE = scale;

        gameBoard = new GameBoard(WIDTH, HEIGHT);

        gameBoard.set(10, 10, true);
        gameBoard.set(10, 11, true);
        gameBoard.set(10, 12, true);
        timer = new Timer(1000 / FPS, e -> update());
        timer.start();
    }

    private void update() {
        gameBoard.step();
        setChanged();
        notifyObservers();
    }

    public boolean get(int x, int y) {
        return gameBoard.get(x, y);
    }

    public void set(int x, int y, boolean b) {
        System.out.println(x + " " + y);

        gameBoard.set(x, y, b);
        setChanged();
        notifyObservers();
    }

    public void playPause(ActionEvent actionEvent) {
        if (timer.isRunning())
            timer.stop();
        else
            timer.start();
    }
}
